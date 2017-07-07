using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Windows.Forms;

namespace Concentration_Dominoes
{
    /**************************
     * Structure : Player
     * **************************/
    struct Player
    {
        private string name;
        private int score;

        public string Name
        {
            get { return name; }
            set { this.name = value; }
        }
        public int Score 
        {
            get { return score; }
            set { this.score = value; }
        }

        public Player(string name, int score)
        {
            this.name = name;
            this.score = score;
        }

        public override string ToString()
        {
           return this.name + ": " + this.score.ToString();
        }

    }

    class Game
    {
        private List<Player> players = new List<Player>();
        private Domino[] dominos= new Domino[Domino.DOMINO_SET_QTY];
        private const int MAX_NUM_PLAYERS = 4,
                          SCORE = 12;
        private Domino domino1 = null,
                       domino2 = null;
        private int dominoCounter = 0; // count disposed tiles
        private int activePlayIndex = 0; // index of current active player
        private bool interupted = false;

        /***************************
         * Delegate events
         * ****************************/
        public delegate void DominoSet(Domino[] dominoTiles);
        public event DominoSet ShowDominoSet;

        public delegate void PlayerStat(List<Player> players, int activePlyIndex);
        public event PlayerStat ShowPlayerStat;

        public delegate void EndGame(string message);
        public event EndGame ShowEndGame;

        public delegate void HideDominos(int index1, int index2);
        public event HideDominos ExecuteHideDominos;

        public delegate void TurnDominos(int index1, int index2);
        public event TurnDominos ExecuteTurnDominos;

        /***************************
         * Properties
         * ****************************/
        public Domino[] Dominos 
        {
            get { return dominos; }
            set { this.dominos = value; }
        }

        public List<Player> Players
        {
            get { return players; }
        }
        
        /**************************
         * Constructor
         * **************************/
        public Game() { this.Dominos = null; this.players = new List<Player>(); }

        /**************************
         * Public methods
         * **************************/
        public void AddPlayer(string name)
        {
            if (players.Count < MAX_NUM_PLAYERS || players == null)
            {
                Player player = new Player(name, 0);
                players.Add(player);
            }
            else
            {
                MessageBox.Show("You have reach the maximum number of players of " + MAX_NUM_PLAYERS + "!");
            }

        }

        public void StartGameMethod()
        {
            Domino.DominoSet(out this.dominos); // initialize domino tiles
            this.dominos = Domino.shuffleDominoSet(this.dominos); // shuffle domino tiles

            ShowDominoSet(dominos); // show tiles
            ShowPlayerStat(players, activePlayIndex); // show active Player
        }

        public void CheckDomino(int indexClicked)
        {
            Domino d = (Domino)dominos[indexClicked];
            if (domino1 == null)
            {
                domino1 = d;
            }
            else if (domino2 == null)
            {
                Thread.Sleep(1000);
                domino2 = d;
                determineScore();
                switchPlayer();
                if (dominoCounter != Domino.DOMINO_SET_QTY)
                {
                    ShowPlayerStat(players, activePlayIndex); // show active Player
                }
            }
            Application.DoEvents();
        }

        /******************************
         * Private Methods
         * *******************************/
        private void switchPlayer()
        {
 	        if(activePlayIndex == players.Count - 1)
            {
                activePlayIndex = 0;
            }
            else
            {
                activePlayIndex++;
            }
        }

        private void determineScore()
        {
            if ((int)domino1.DomVal + (int)domino2.DomVal == SCORE)
            {
                dominoCounter += 2;

                // add score
                Player p = players[activePlayIndex];
                p.Score += SCORE;
                players[activePlayIndex] = p;

                // event to take Tiles away
                ExecuteHideDominos((int)domino1.IndexInCollection, (int)domino2.IndexInCollection);
                domino1 = null;
                domino2 = null;

                // determine the winner
                if (dominoCounter == Domino.DOMINO_SET_QTY)
                {
                    int highScore = 0;
                    string winnerMessage = "";

                    // set high score
                    for (int i = 0; i < players.Count; i++)
                    {
                        if ((int)players[i].Score > highScore)
                        {
                            highScore = (int)players[i].Score;
                        }
                    }

                    // remove other than high scoring player
                    for (int i = players.Count - 1; i > 0; i--)
                    {
                        if ((int)players[i].Score < highScore)
                        {
                            players.RemoveAt(i);
                        }
                    }

                    // create winner player string
                    foreach (Player player in players)
                    {
                        winnerMessage += player.ToString() + "   ";                        
                    }
                    ShowEndGame(winnerMessage);
                }
            }
            else
            {
                ExecuteTurnDominos((int)domino1.IndexInCollection, (int)domino2.IndexInCollection);
                domino1 = null;
                domino2 = null;
            }
            Application.DoEvents();
        }
    }
}
