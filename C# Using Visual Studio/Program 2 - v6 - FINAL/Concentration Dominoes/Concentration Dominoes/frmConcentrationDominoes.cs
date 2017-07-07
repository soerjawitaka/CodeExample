using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading;
using System.Windows.Forms;

namespace Concentration_Dominoes
{
    public partial class frmConcentrationDominoes : Form
    {
        private const int COLUMN_IN_A_ROW = 7;
        private Game game = null;
        private PictureBox[] dominoImg = null;
        private string backTileFilePath = "../../Resources/backTile1.jpg";
        
        public frmConcentrationDominoes()
        {
            InitializeComponent();
        }

        /********************************
         * Event Handlers
         * **********************************/
        private void frmConcentrationDominoes_Load(object sender, EventArgs e)
        {
            initializeGame();
            txtName.Text = "";
            txtName.Focus();
        }

        private void btnExit_Click(object sender, EventArgs e)
        {
            this.Dispose();
        }

        private void newGameToolStripMenuItem_Click(object sender, EventArgs e)
        {
            initializeGame();

            if (dominoImg != null)
            {
                foreach (PictureBox pbo in dominoImg)
                {
                    pbo.Dispose();
                }
            }
            
            txtName.Text = "";
            txtName.Focus();
            lblPlayerList.Text = "";
            mainMenuMode();
            btnPlay.Enabled = false;
        }

        private void rulesToolStripMenuItem_Click(object sender, EventArgs e)
        {
            frmGameRules gameRules = new frmGameRules();
            gameRules.Show();
        }

        private void exitToolStripMenuItem_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void btnAddPlayer_Click(object sender, EventArgs e)
        {
            if (txtName.Text != "" || txtName.Text != null)
            {
                btnPlay.Enabled = true;
                game.AddPlayer(txtName.Text);

                if (game.Players == null)
                    lblPlayerList.Text = game.Players[0].Name;
                else
                    lblPlayerList.Text += "\t\r" + game.Players.Last().Name;

                txtName.Text = "";
                txtName.Focus();
            }
            else if (txtName.Text == "" || txtName.Text == null)
            {
                MessageBox.Show("No name detected. Please enter your name with a maximum of 6 characters!",
                                "No Entry", MessageBoxButtons.OK, MessageBoxIcon.Warning);
            }
        }

        private void btnPlay_Click(object sender, EventArgs e)
        {
            playMode();
            backTileFilePath = getBackTileFilePath(); // get back tile pattern 
            game.StartGameMethod(); // initializa the game           
        }

        // handles clicked tiles 
        private void ClickedDomino(object sender, EventArgs e)
        {
            PictureBox clickedTile = (PictureBox)sender;
            clickedTile.Image = null;
            Application.DoEvents();
            int indexClicked = Convert.ToInt32(clickedTile.Tag);
            game.CheckDomino(indexClicked);
        }

        private void rdo1_CheckedChanged(object sender, EventArgs e)
        {
            pboBackground.Image = new Bitmap("../../Resources/backTile1.jpg");
        }
        private void rdo2_CheckedChanged(object sender, EventArgs e)
        {
            pboBackground.Image = new Bitmap("../../Resources/backTile2.jpg");
        }
        private void rdo3_CheckedChanged(object sender, EventArgs e)
        {
            pboBackground.Image = new Bitmap("../../Resources/backTile3.jpg");
        }

        /*****************************
         * delegated event handlers
         * *******************************/
        void game_ShowEndGame(string message)
        {
            gboMain.Text = "";
            gboControls.Text = "The Winner";
            lblScores.Text = message;
            Application.DoEvents();
        }

        void game_ExecuteTurnDominos(int index1, int index2)
        {
            dominoImg[index1].Image = new Bitmap(backTileFilePath);
            dominoImg[index2].Image = new Bitmap(backTileFilePath);
        }

        void game_ExecuteHideDominos(int index1, int index2)
        {
            dominoImg[index1].Dispose();
            dominoImg[index2].Dispose();
        }

        private void game_ShowDominoSet(Domino[] dominoTiles)
        {
            // initialize variables
            int startLeft = 25,
                startTop = 40,
                left = 0,
                top = 0;

            dominoImg = new PictureBox[Domino.DOMINO_SET_QTY]; // initialize the array
            for (int i = 0; i < dominoImg.Length; i++)
            {
                if (i % COLUMN_IN_A_ROW == 0 && i != 0)
                {
                    left = 0;
                    top++;
                }
                dominoImg[i] = new PictureBox();
                dominoImg[i].Location = new System.Drawing.Point(startLeft + (left * 75), startTop + (top * 125));
                dominoImg[i].Size = new System.Drawing.Size(50, 100);
                dominoImg[i].BackgroundImage = new Bitmap((string)game.Dominos[i].ImgPath);
                dominoImg[i].Image = new Bitmap(backTileFilePath);
                dominoImg[i].Tag = i.ToString();
                dominoImg[i].Click += new EventHandler(ClickedDomino);
                gboMain.Controls.Add(dominoImg[i]);
                left++;
            }
        }

        void game_ShowPlayerStat(List<Player> players, int activePlyIndex)
        {
            gboMain.Text = game.Players[activePlyIndex].Name; // display active player's name
            string scoreString = "| ";
            foreach (Player player in game.Players)
                scoreString += player.ToString() + " | "; // set scoreboard
            lblScores.Text = scoreString;
        }


        /****************************
         * Private methods
         * ****************************/
        private void initializeGame()
        {
            game = new Game();
            game.ExecuteHideDominos += game_ExecuteHideDominos;
            game.ExecuteTurnDominos += game_ExecuteTurnDominos;
            game.ShowEndGame += game_ShowEndGame;
            game.ShowDominoSet += game_ShowDominoSet;
            game.ShowPlayerStat += game_ShowPlayerStat;
        }
        
        private void playMode()
        {
            lblName.Visible = false;
            txtName.Visible = false;
            gboBckgrndSelection.Visible = false;
            gboPlayerList.Visible = false;
            btnAddPlayer.Visible = false;
            btnPlay.Visible = false;
            gboMain.Text = "";
        }

        private void mainMenuMode()
        {
            lblName.Visible = true;
            txtName.Visible = true;
            gboBckgrndSelection.Visible = true;
            gboPlayerList.Visible = true;
            btnAddPlayer.Visible = true;
            btnPlay.Visible = true;
            gboMain.Text = "Main Menu";
        }

        private string getBackTileFilePath()
        {
            string path = "";
            if (rdo1.Checked)
                path = "../../Resources/backTile1.jpg";
            else if (rdo2.Checked)
                path = "../../Resources/backTile2.jpg";
            else if (rdo3.Checked)
                path = "../../Resources/backTile3.jpg";

            return path;
        }
    }
}
