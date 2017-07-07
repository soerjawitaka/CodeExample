using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Concentration_Dominoes
{
    class Domino
    {
        // constant
        public const int DOMINO_SET_QTY = 28;

        public int Xindex { get; set; }
        public int Yindex { get; set; }
        public int IndexInCollection { get; set; }
        public int DomVal
        {
            get { return this.Xindex + this.Yindex; }
        }
         public string ImgPath 
        {
            get { return "../../Resources/" + this.Xindex.ToString() + "-" + this.Yindex.ToString() + ".png"; }
        }

        /********************************
         * Cunstructors
         * ********************************/
        public Domino() { }

        public Domino(int x, int y, int index)
        {
            this.Xindex = x;
            this.Yindex = y;
            this.IndexInCollection = index;
        }   
     
        /*****************************
         * public static methods
         * ******************************/
        public static void DominoSet(out Domino[] dominos)
        {
            dominos = new Domino[28];
            int x = 0, y = 0;

            for (int i = 0; i < dominos.Length; i++)
            {
                if (y > x)
                {
                    x++;
                    y = 0;
                }
                if (y <= x)
                {
                    Domino dom = new Domino(x, y, i);
                    dominos[i] = dom;
                    y++;
                }
            }
        }

        public static Domino[] shuffleDominoSet(Domino[] dominoSet)
        {
            for (int i = 0; i < dominoSet.Length; i++)
            {
                Domino tempDom = dominoSet[i];
                int randomIndex = 0;
                do
                {
                    randomIndex = new Random().Next(0, dominoSet.Length);
                }
                while (randomIndex == i); 

                dominoSet[i] = dominoSet[randomIndex];
                dominoSet[i].IndexInCollection = i; // set tile's index in collection
                dominoSet[randomIndex] = tempDom;
                dominoSet[randomIndex].IndexInCollection = randomIndex;
            }
            return dominoSet;
        }

    }
}
