namespace Concentration_Dominoes
{
    partial class frmConcentrationDominoes
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.menuStrip1 = new System.Windows.Forms.MenuStrip();
            this.newGameToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.rulesToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.exitToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.lblScores = new System.Windows.Forms.Label();
            this.gboControls = new System.Windows.Forms.GroupBox();
            this.btnAddPlayer = new System.Windows.Forms.Button();
            this.btnExit = new System.Windows.Forms.Button();
            this.label1 = new System.Windows.Forms.Label();
            this.gboMain = new System.Windows.Forms.GroupBox();
            this.gboPlayerList = new System.Windows.Forms.GroupBox();
            this.lblPlayerList = new System.Windows.Forms.Label();
            this.gboBckgrndSelection = new System.Windows.Forms.GroupBox();
            this.rdo3 = new System.Windows.Forms.RadioButton();
            this.pboBackground = new System.Windows.Forms.PictureBox();
            this.rdo1 = new System.Windows.Forms.RadioButton();
            this.rdo2 = new System.Windows.Forms.RadioButton();
            this.txtName = new System.Windows.Forms.TextBox();
            this.lblName = new System.Windows.Forms.Label();
            this.btnPlay = new System.Windows.Forms.Button();
            this.menuStrip1.SuspendLayout();
            this.gboControls.SuspendLayout();
            this.gboMain.SuspendLayout();
            this.gboPlayerList.SuspendLayout();
            this.gboBckgrndSelection.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.pboBackground)).BeginInit();
            this.SuspendLayout();
            // 
            // menuStrip1
            // 
            this.menuStrip1.ImageScalingSize = new System.Drawing.Size(20, 20);
            this.menuStrip1.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.newGameToolStripMenuItem,
            this.rulesToolStripMenuItem,
            this.exitToolStripMenuItem});
            this.menuStrip1.Location = new System.Drawing.Point(0, 0);
            this.menuStrip1.Name = "menuStrip1";
            this.menuStrip1.Size = new System.Drawing.Size(599, 24);
            this.menuStrip1.TabIndex = 14;
            this.menuStrip1.Text = "menuStrip1";
            // 
            // newGameToolStripMenuItem
            // 
            this.newGameToolStripMenuItem.Name = "newGameToolStripMenuItem";
            this.newGameToolStripMenuItem.Size = new System.Drawing.Size(77, 20);
            this.newGameToolStripMenuItem.Text = "&New Game";
            this.newGameToolStripMenuItem.Click += new System.EventHandler(this.newGameToolStripMenuItem_Click);
            // 
            // rulesToolStripMenuItem
            // 
            this.rulesToolStripMenuItem.Name = "rulesToolStripMenuItem";
            this.rulesToolStripMenuItem.Size = new System.Drawing.Size(47, 20);
            this.rulesToolStripMenuItem.Text = "&Rules";
            this.rulesToolStripMenuItem.Click += new System.EventHandler(this.rulesToolStripMenuItem_Click);
            // 
            // exitToolStripMenuItem
            // 
            this.exitToolStripMenuItem.Name = "exitToolStripMenuItem";
            this.exitToolStripMenuItem.Size = new System.Drawing.Size(37, 20);
            this.exitToolStripMenuItem.Text = "E&xit";
            this.exitToolStripMenuItem.Click += new System.EventHandler(this.exitToolStripMenuItem_Click);
            // 
            // lblScores
            // 
            this.lblScores.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(192)))), ((int)(((byte)(64)))), ((int)(((byte)(0)))));
            this.lblScores.ForeColor = System.Drawing.SystemColors.ControlText;
            this.lblScores.ImageAlign = System.Drawing.ContentAlignment.TopCenter;
            this.lblScores.Location = new System.Drawing.Point(0, 30);
            this.lblScores.Name = "lblScores";
            this.lblScores.Size = new System.Drawing.Size(560, 44);
            this.lblScores.TabIndex = 15;
            this.lblScores.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            // 
            // gboControls
            // 
            this.gboControls.Controls.Add(this.lblScores);
            this.gboControls.Font = new System.Drawing.Font("Freestyle Script", 24F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.gboControls.ForeColor = System.Drawing.SystemColors.ControlLightLight;
            this.gboControls.Location = new System.Drawing.Point(18, 664);
            this.gboControls.Margin = new System.Windows.Forms.Padding(3, 3, 3, 12);
            this.gboControls.Name = "gboControls";
            this.gboControls.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.gboControls.Size = new System.Drawing.Size(560, 83);
            this.gboControls.TabIndex = 16;
            this.gboControls.TabStop = false;
            this.gboControls.Text = "Scores";
            // 
            // btnAddPlayer
            // 
            this.btnAddPlayer.Font = new System.Drawing.Font("Ravie", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnAddPlayer.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(192)))), ((int)(((byte)(64)))), ((int)(((byte)(0)))));
            this.btnAddPlayer.Location = new System.Drawing.Point(226, 188);
            this.btnAddPlayer.Name = "btnAddPlayer";
            this.btnAddPlayer.Size = new System.Drawing.Size(231, 33);
            this.btnAddPlayer.TabIndex = 17;
            this.btnAddPlayer.Text = "&Add Player";
            this.btnAddPlayer.Click += new System.EventHandler(this.btnAddPlayer_Click);
            // 
            // btnExit
            // 
            this.btnExit.DialogResult = System.Windows.Forms.DialogResult.Cancel;
            this.btnExit.Location = new System.Drawing.Point(502, 498);
            this.btnExit.Name = "btnExit";
            this.btnExit.Size = new System.Drawing.Size(14, 8);
            this.btnExit.TabIndex = 20;
            this.btnExit.UseVisualStyleBackColor = true;
            this.btnExit.Visible = false;
            this.btnExit.Click += new System.EventHandler(this.btnExit_Click);
            // 
            // label1
            // 
            this.label1.BackColor = System.Drawing.SystemColors.ActiveCaptionText;
            this.label1.Font = new System.Drawing.Font("Ravie", 18F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.Image = global::Concentration_Dominoes.Properties.Resources.halloween;
            this.label1.Location = new System.Drawing.Point(12, 45);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(567, 46);
            this.label1.TabIndex = 0;
            this.label1.Text = "Memory Domino";
            this.label1.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            // 
            // gboMain
            // 
            this.gboMain.BackgroundImage = global::Concentration_Dominoes.Properties.Resources.halloween;
            this.gboMain.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
            this.gboMain.Controls.Add(this.gboPlayerList);
            this.gboMain.Controls.Add(this.gboBckgrndSelection);
            this.gboMain.Controls.Add(this.btnExit);
            this.gboMain.Controls.Add(this.txtName);
            this.gboMain.Controls.Add(this.lblName);
            this.gboMain.Controls.Add(this.btnAddPlayer);
            this.gboMain.Controls.Add(this.btnPlay);
            this.gboMain.FlatStyle = System.Windows.Forms.FlatStyle.Popup;
            this.gboMain.Font = new System.Drawing.Font("Freestyle Script", 24F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.gboMain.ForeColor = System.Drawing.SystemColors.ControlLightLight;
            this.gboMain.Location = new System.Drawing.Point(18, 114);
            this.gboMain.Name = "gboMain";
            this.gboMain.Padding = new System.Windows.Forms.Padding(0);
            this.gboMain.RightToLeft = System.Windows.Forms.RightToLeft.No;
            this.gboMain.Size = new System.Drawing.Size(561, 533);
            this.gboMain.TabIndex = 12;
            this.gboMain.TabStop = false;
            this.gboMain.Text = "Main Menu";
            // 
            // gboPlayerList
            // 
            this.gboPlayerList.BackColor = System.Drawing.Color.Transparent;
            this.gboPlayerList.Controls.Add(this.lblPlayerList);
            this.gboPlayerList.Location = new System.Drawing.Point(77, 188);
            this.gboPlayerList.Margin = new System.Windows.Forms.Padding(2);
            this.gboPlayerList.Name = "gboPlayerList";
            this.gboPlayerList.Padding = new System.Windows.Forms.Padding(2);
            this.gboPlayerList.Size = new System.Drawing.Size(106, 155);
            this.gboPlayerList.TabIndex = 23;
            this.gboPlayerList.TabStop = false;
            this.gboPlayerList.Text = "Players";
            // 
            // lblPlayerList
            // 
            this.lblPlayerList.Font = new System.Drawing.Font("Ravie", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblPlayerList.ForeColor = System.Drawing.Color.Black;
            this.lblPlayerList.Location = new System.Drawing.Point(0, 16);
            this.lblPlayerList.Margin = new System.Windows.Forms.Padding(0);
            this.lblPlayerList.Name = "lblPlayerList";
            this.lblPlayerList.Size = new System.Drawing.Size(106, 137);
            this.lblPlayerList.TabIndex = 0;
            this.lblPlayerList.TextAlign = System.Drawing.ContentAlignment.TopCenter;
            // 
            // gboBckgrndSelection
            // 
            this.gboBckgrndSelection.BackColor = System.Drawing.Color.Transparent;
            this.gboBckgrndSelection.Controls.Add(this.rdo3);
            this.gboBckgrndSelection.Controls.Add(this.pboBackground);
            this.gboBckgrndSelection.Controls.Add(this.rdo1);
            this.gboBckgrndSelection.Controls.Add(this.rdo2);
            this.gboBckgrndSelection.ForeColor = System.Drawing.Color.Black;
            this.gboBckgrndSelection.Location = new System.Drawing.Point(228, 227);
            this.gboBckgrndSelection.Name = "gboBckgrndSelection";
            this.gboBckgrndSelection.Size = new System.Drawing.Size(229, 154);
            this.gboBckgrndSelection.TabIndex = 22;
            this.gboBckgrndSelection.TabStop = false;
            this.gboBckgrndSelection.Text = "Background";
            // 
            // rdo3
            // 
            this.rdo3.AutoSize = true;
            this.rdo3.Font = new System.Drawing.Font("Freestyle Script", 15.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.rdo3.Location = new System.Drawing.Point(96, 109);
            this.rdo3.Name = "rdo3";
            this.rdo3.Size = new System.Drawing.Size(64, 29);
            this.rdo3.TabIndex = 24;
            this.rdo3.TabStop = true;
            this.rdo3.Text = "Skull";
            this.rdo3.UseVisualStyleBackColor = true;
            this.rdo3.CheckedChanged += new System.EventHandler(this.rdo3_CheckedChanged);
            // 
            // pboBackground
            // 
            this.pboBackground.BackColor = System.Drawing.Color.Black;
            this.pboBackground.Image = global::Concentration_Dominoes.Properties.Resources.backTile1;
            this.pboBackground.Location = new System.Drawing.Point(25, 39);
            this.pboBackground.Name = "pboBackground";
            this.pboBackground.Size = new System.Drawing.Size(50, 100);
            this.pboBackground.TabIndex = 21;
            this.pboBackground.TabStop = false;
            // 
            // rdo1
            // 
            this.rdo1.AutoSize = true;
            this.rdo1.Checked = true;
            this.rdo1.Font = new System.Drawing.Font("Freestyle Script", 15.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.rdo1.Location = new System.Drawing.Point(96, 39);
            this.rdo1.Name = "rdo1";
            this.rdo1.Size = new System.Drawing.Size(121, 29);
            this.rdo1.TabIndex = 22;
            this.rdo1.TabStop = true;
            this.rdo1.Text = "Pumpkin Ghost";
            this.rdo1.UseVisualStyleBackColor = true;
            this.rdo1.CheckedChanged += new System.EventHandler(this.rdo1_CheckedChanged);
            // 
            // rdo2
            // 
            this.rdo2.AutoSize = true;
            this.rdo2.Font = new System.Drawing.Font("Freestyle Script", 15.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.rdo2.Location = new System.Drawing.Point(95, 74);
            this.rdo2.Name = "rdo2";
            this.rdo2.Size = new System.Drawing.Size(63, 29);
            this.rdo2.TabIndex = 23;
            this.rdo2.TabStop = true;
            this.rdo2.Text = "Vines";
            this.rdo2.UseVisualStyleBackColor = true;
            this.rdo2.CheckedChanged += new System.EventHandler(this.rdo2_CheckedChanged);
            // 
            // txtName
            // 
            this.txtName.BackColor = System.Drawing.SystemColors.MenuText;
            this.txtName.Font = new System.Drawing.Font("Ravie", 18F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.txtName.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(192)))), ((int)(((byte)(64)))), ((int)(((byte)(0)))));
            this.txtName.Location = new System.Drawing.Point(226, 143);
            this.txtName.MaxLength = 6;
            this.txtName.Name = "txtName";
            this.txtName.Size = new System.Drawing.Size(231, 39);
            this.txtName.TabIndex = 19;
            // 
            // lblName
            // 
            this.lblName.AutoSize = true;
            this.lblName.BackColor = System.Drawing.Color.Transparent;
            this.lblName.Font = new System.Drawing.Font("Ravie", 18F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblName.ForeColor = System.Drawing.SystemColors.ControlText;
            this.lblName.Location = new System.Drawing.Point(109, 146);
            this.lblName.Name = "lblName";
            this.lblName.Size = new System.Drawing.Size(111, 34);
            this.lblName.TabIndex = 18;
            this.lblName.Text = "Name:";
            // 
            // btnPlay
            // 
            this.btnPlay.Enabled = false;
            this.btnPlay.Font = new System.Drawing.Font("Ravie", 18F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnPlay.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(192)))), ((int)(((byte)(64)))), ((int)(((byte)(0)))));
            this.btnPlay.Location = new System.Drawing.Point(226, 387);
            this.btnPlay.Name = "btnPlay";
            this.btnPlay.Size = new System.Drawing.Size(117, 73);
            this.btnPlay.TabIndex = 16;
            this.btnPlay.Text = "&Play";
            this.btnPlay.Click += new System.EventHandler(this.btnPlay_Click);
            // 
            // frmConcentrationDominoes
            // 
            this.AcceptButton = this.btnAddPlayer;
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.AutoScroll = true;
            this.AutoSize = true;
            this.BackColor = System.Drawing.Color.Black;
            this.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Center;
            this.CancelButton = this.btnExit;
            this.ClientSize = new System.Drawing.Size(599, 771);
            this.Controls.Add(this.gboControls);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.gboMain);
            this.Controls.Add(this.menuStrip1);
            this.MainMenuStrip = this.menuStrip1;
            this.Name = "frmConcentrationDominoes";
            this.Text = "Concentration Dominoes";
            this.Load += new System.EventHandler(this.frmConcentrationDominoes_Load);
            this.menuStrip1.ResumeLayout(false);
            this.menuStrip1.PerformLayout();
            this.gboControls.ResumeLayout(false);
            this.gboMain.ResumeLayout(false);
            this.gboMain.PerformLayout();
            this.gboPlayerList.ResumeLayout(false);
            this.gboBckgrndSelection.ResumeLayout(false);
            this.gboBckgrndSelection.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.pboBackground)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.GroupBox gboMain;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.MenuStrip menuStrip1;
        private System.Windows.Forms.ToolStripMenuItem newGameToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem rulesToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem exitToolStripMenuItem;
        private System.Windows.Forms.Label lblScores;
        private System.Windows.Forms.GroupBox gboControls;
        private System.Windows.Forms.Button btnAddPlayer;
        private System.Windows.Forms.Button btnPlay;
        private System.Windows.Forms.TextBox txtName;
        private System.Windows.Forms.Label lblName;
        private System.Windows.Forms.Button btnExit;
        private System.Windows.Forms.PictureBox pboBackground;
        private System.Windows.Forms.GroupBox gboBckgrndSelection;
        private System.Windows.Forms.RadioButton rdo3;
        private System.Windows.Forms.RadioButton rdo1;
        private System.Windows.Forms.RadioButton rdo2;
        private System.Windows.Forms.GroupBox gboPlayerList;
        private System.Windows.Forms.Label lblPlayerList;
    }
}

