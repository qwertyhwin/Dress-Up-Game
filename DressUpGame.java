import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Font;
import java.awt.geom.CubicCurve2D;
import java.util.Arrays;

/**
 * Extra part of CS312 Assignment 3 (called Scintillation Grid) - to create your own drawing.
 *
 * A program to print out a customizable drawing of a person.
 *
 */

public class DressUpGame {
    public static Color skin;
    public static Color shadeSkin;
    public static Color mouth;
    public static Color eye;
    public static Color eyeDark;
    public static Color hair;
    public static Color outfit;
    public static Color hairBlack = new Color(38,38,38);
    public static Color hairDarkBrown = new Color(51,24,7);
    public static Color hairBlonde = new Color(239,222,88);
    public static Color hairLightBrown = new Color(198,161,101);
    public static Color hairPinkBrown = new Color(198,138,101);
    public static Color hairBlue = new Color(85,119,116);
    public static Color hairGreen = new Color(135,155,37);
    public static Color hairPink = new Color(224,143,163);
    public static Color hairPurple = new Color(114,64,142);
    public static Color hairRed = new Color(175,21,36);
    public static Color hairGray = new Color(186,186,186);
    public static Color eyeBrown = new Color(91,56,40);
    public static Color eyeLightBlue = new Color(45,153,135);
    public static Color eyeBlue = new Color(68,85,95);
    public static Color eyeGreen = new Color(97,132,31);
    public static Color eyeGolden = new Color(188,155,33);
    public static Color eyePink = new Color(188,64,89);
    public static Color eyePurple = new Color(140,68,175);
    public static Color eyeRed = new Color(186,35,35);
    public static Color eyeGray = new Color(155,155,155);
    public static Color outfitGreen = new Color(211,189,41);
    public static Color outfitYellow = new Color(247,219,59);
    public static Color outfitNavyBlue = new Color(34,62,107);
    public static Color outfitWhite = new Color(245,245,237);
    public static Color outfitBlack = Color.black;
    public static Color outfitRed = new Color(186,35,35);
    public static Color outfitTan = new Color(198,161,101);
    
    public static int x = -50;
    public static int y = -100;
    public static void drawingOne() {
        DrawingPanel dp = new DrawingPanel(1000,1200);
        Graphics g = dp.getGraphics();
        dp.setBackground(new Color(155,215,210));
        
        x = -50; //initial position
        y = -100; //initial position
        double a = 1; //scaling
        
        g.drawLine(0,0,1000,0); //random line to fulfill the "must draw a line" requirement
        
        
        
           //////////////////// TO CUSTOMIZE YOUR CHARACTER ///////////////////////
        ///////// UNCOMMENT YOUR SELECTION AND COMMENT OUT THE OTHER CHOICES //////////
        
         /* HAIR COLOR OPTIONS */
        hair = hairDarkBrown;
        //hair = hairBlack;
        //hair = hairBlonde;
        //hair = hairLightBrown;
        //hair = hairPinkBrown;
        //hair = hairBlue;
        //hair = hairGreen;
        //hair = hairPink;
        //hair = hairPurple;
        //hair = hairRed;
        //hair = hairGray;
        
         /* HAIR STYLE OPTIONS */
        //drawHair0(g,x,y,a); //bald
        drawHairBob(g,x,y,a);
        //drawHairAfro(g,x,y,a);
        
         /* OUTFIT COLOR OPTIONS */
        outfit = outfitGreen;
        //outfit = outfitYellow;
        //outfit = outfitNavyBlue;
        //outfit = outfitWhite;
        //outfit = outfitBlack;
        //outfit = outfitRed;
        //outfit = outfitTan;
        
        drawOutfit(g,x,y,a);
        
         /* SKIN COLOR OPTIONS */
        //chooseSkinColor1(g);
        //chooseSkinColor2(g);
        //chooseSkinColor3(g);
        chooseSkinColor4(g);
           
        drawHead(g,x,y,a);
        
         /* EYE COLOR OPTIONS */
        chooseEyeColorBrown(g);
        //chooseEyeColorBlue(g);
        //chooseEyeColorLightBlue(g);
        //chooseEyeColorGreen(g);
        //chooseEyeColorGolden(g);
        //chooseEyeColorPink(g);
        //chooseEyeColorPurple(g);
        //chooseEyeColorRed(g);
        //chooseEyeColorGray(g);
        
         /* EYE OPTIONS */
        //drawEyes1(g,x,y,a); //plain circles
        //drawEyes2(g,x,y,a); //sparkly eyes
        //drawEyes3(g,x,y,a); //closed eyes
        drawEyes4(g,x,y,a); //smiling eyes
        
         /* MOUTH OPTIONS */
        //drawMouth1(g,x,y,a); //open mouth
        drawMouth2(g,x,y,a); //smile
        //drawMouth3(g,x,y,a); //frown
        
         /* BANGS OPTIONS */
        drawBangsStraight(g,x,y,a);
        //drawBangsAfro(g,x,y,a);
        
         /* EYEBROW OPTIONS */
        drawEyebrow0(g,x,y,a); //no eyebrows
        //drawEyebrow1(g,x,y,a); //angry
        //drawEyebrow2(g,x,y,a); //worried
        
        
        //Display Preview of Options
        preview(g,a);
    }
    public static void preview(Graphics g, double a) {
        g.setFont(new Font("Courier", Font.BOLD, (int)(20*a)));
        g.setColor(Color.white);
        g.drawString("create your own character!",(int)(155*a),(int)(55*a));
        g.setFont(new Font("Courier", Font.BOLD, (int)(15*a)));
        g.drawString("(edit the drawingOne method)",(int)(180*a),(int)(75*a));
        g.setFont(new Font("Courier", Font.BOLD, (int)(25*a)));
        g.drawString("↓",(int)(270*a),(int)(110*a));
        
        //Skin color preview
        x = -180;
        y = -40;
        double localA = 0.5*a;
        chooseSkinColor1(g);
        drawHead(g,x,y,localA);
        y = 110;
        chooseSkinColor2(g);
        drawHead(g,x,y,localA);
        y = 260;
        chooseSkinColor3(g);
        drawHead(g,x,y,localA);
        y = 410;
        chooseSkinColor4(g);
        drawHead(g,x,y,localA);
        g.setFont(new Font("Courier", Font.BOLD,(int)(18*a)));
        g.setColor(Color.white);
        g.drawString("skin",(int)(50*a),(int)(75*a));
        g.drawString("colors",(int)(40*a),(int)(90*a));
        
        //hair preview
        x = 670;
        y = -40;
        chooseSkinColor1(g);
        drawHead(g,x,y,localA);
        y = 120;
        hair = hairDarkBrown;
        drawHairAfro(g,x,y,localA);
        chooseSkinColor2(g);
        drawHead(g,x,y,localA);
        hair = hairDarkBrown;
        drawBangsAfro(g,x,y,localA);
        y = 280;
        hair = hairPinkBrown;
        drawHairBob(g,x,y,localA);
        chooseSkinColor3(g);
        drawHead(g,x,y,localA);
        hair = hairPinkBrown;
        drawBangsStraight(g,x,y,localA);
        y = 440;
        chooseSkinColor4(g);
        drawHead(g,x,y,localA);
        hair = hairDarkBrown;
        drawBangsStraight(g,x,y,localA);
        
        //eye options
        x = -170;
        y = 660; //+160
        chooseSkinColor1(g);
        drawHead(g,x,y,localA);
        chooseEyeColorBrown(g);
        drawEyes1(g,x,y,localA);
        y = 820;
        hair = hairDarkBrown;
        drawHairAfro(g,x,y,localA);
        chooseSkinColor2(g);
        drawHead(g,x,y,localA);
        chooseEyeColorBrown(g);
        drawEyes2(g,x,y,localA);
        hair = hairDarkBrown;
        drawBangsAfro(g,x,y,localA);
        y = 980;
        hair = hairPinkBrown;
        drawHairBob(g,x,y,localA);
        chooseSkinColor3(g);
        drawHead(g,x,y,localA);
        drawEyes3(g,x,y,localA);
        hair = hairPinkBrown;
        drawBangsStraight(g,x,y,localA);
        y = 1140;
        chooseSkinColor4(g);
        drawHead(g,x,y,localA);
        drawEyes4(g,x,y,localA);
        hair = hairDarkBrown;
        drawBangsStraight(g,x,y,localA);
        g.setFont(new Font("Courier", Font.BOLD,(int)(18*a)));
        g.setColor(Color.white);
        g.drawString("eye options",(int)(27*a),(int)(445*a));
        
        //hair color preview
        int sizePreviewCircle = 19;
        Color[] hairColors = {hairBlack, hairDarkBrown, hairBlonde, hairLightBrown, hairPinkBrown, hairBlue, hairGreen, hairPink, hairPurple, hairRed, hairGray};
        for(int i = 0; i < hairColors.length; i++) {
            g.setColor(hairColors[i]);
            g.fillOval((int)(580*a),(int)((150+20*i)*a),(int)(sizePreviewCircle*a),(int)(sizePreviewCircle*a));
        }
        g.setFont(new Font("Courier", Font.BOLD,(int)(18*a)));
        g.setColor(Color.white);
        g.drawString("hair styles",(int)(450*a),(int)(80*a));
        g.drawString("hair",(int)(573*a),(int)(120*a));
        g.drawString("colors",(int)(563*a),(int)(140*a));
        
        //eye color options
        Color[] eyeColors = {eyeBrown, eyeLightBlue, eyeBlue, eyeGreen, eyeGolden, eyePink, eyePurple, eyeRed, eyeGray};
        for(int i = 0; i < eyeColors.length; i++) {
            g.setColor(eyeColors[i]);
            g.fillOval((int)(165*a),(int)((510+20*i)*a),(int)(sizePreviewCircle*a),(int)(sizePreviewCircle*a));
        }
        g.setFont(new Font("Courier", Font.BOLD,(int)(18*a)));
        g.setColor(Color.white);
        g.drawString("eye",(int)(160*a),(int)(480*a));
        g.drawString("colors",(int)(147*a),(int)(500*a));
        
        //outfit colors
        Color[] outfitColors = {outfitGreen, outfitYellow, outfitNavyBlue, outfitWhite, outfitBlack, outfitRed, outfitTan};
        for(int i = 0; i < outfitColors.length; i++) {
            g.setColor(outfitColors[i]);
            g.fillOval((int)((250+20*i)*a),(int)(680*a),(int)(sizePreviewCircle*a),(int)(sizePreviewCircle*a));
        }
        g.setFont(new Font("Courier", Font.BOLD,(int)(18*a)));
        g.setColor(Color.white);
        g.drawString("outfit colors",(int)(400*a),(int)(695*a));
        
        //eyebrows mouth and shirts preview
        x = 180;
        y = 570;
        localA = 0.6*a;
        hair = hairPinkBrown;
        drawHairBob(g,x,y,localA);
        outfit = outfitYellow;
        drawOutfit(g,x,y,localA);
        chooseSkinColor3(g);
        drawHead(g,x,y,localA);
        drawEyes3(g,x,y,localA);
        drawMouth2(g,x,y,localA);
        drawEyebrow0(g,x,y,localA);
        hair = hairPinkBrown;
        drawBangsStraight(g,x,y,localA);
        
        x = 400;
        outfit = outfitRed;
        drawOutfit(g,x,y,localA);
        chooseSkinColor4(g);
        drawHead(g,x,y,localA);
        chooseEyeColorBlue(g);
        drawEyes2(g,x,y,localA);
        drawMouth1(g,x,y,localA);
        hair = hairBlue;
        drawBangsStraight(g,x,y,localA);
        drawEyebrow2(g,x,y,localA);
        
        x = 620;
        hair = hairPurple;
        drawHairBob(g,x,y,localA);
        outfit = outfitNavyBlue;
        drawOutfit(g,x,y,localA);
        chooseSkinColor2(g);
        drawHead(g,x,y,localA);
        chooseEyeColorBrown(g);
        drawEyes2(g,x,y,localA);
        drawMouth3(g,x,y,localA);
        drawEyebrow0(g,x,y,localA);
        hair = hairPurple;
        drawBangsStraight(g,x,y,localA);
        drawEyebrow1(g,x,y,localA);
        g.setFont(new Font("Courier", Font.BOLD,(int)(18*a)));
        g.setColor(Color.white);
        g.drawString("3 different options for eyebrows + mouths",(int)(235*a),(int)(470*a));
    }
    public static void chooseSkinColor1(Graphics g) {
        skin = new Color(223,178,139);
        shadeSkin = new Color(216,158,115);
        mouth = new Color(178,109,60);
    }
    public static void chooseSkinColor2(Graphics g) {
        skin = new Color(164,108,53);
        shadeSkin = new Color(125,73,33);
        mouth = new Color(109,54,24);
    }
    public static void chooseSkinColor3(Graphics g) {
        skin = new Color(236,193,156);
        shadeSkin = new Color(229,178,140);
        mouth = new Color(204,131,89);
    }
    public static void chooseSkinColor4(Graphics g) {
        skin = new Color(229,191,131);
        shadeSkin = new Color(219,173,106);
        mouth = new Color(206,151,92);
    }
    public static void chooseEyeColorBrown(Graphics g) {
        eye = eyeBrown;
        eyeDark = new Color(53,17,20);
    }
    public static void chooseEyeColorLightBlue(Graphics g) {
        eye = eyeLightBlue;
        eyeDark = new Color(2,85,86);
    }
    public static void chooseEyeColorBlue(Graphics g) {
        eye = eyeBlue;
        eyeDark = new Color(18,26,29);
    }
    public static void chooseEyeColorGreen(Graphics g) {
        eye = eyeGreen;
        eyeDark = new Color(37,56,3);
    }
    public static void chooseEyeColorGolden(Graphics g) {
        eye = eyeGolden;
        eyeDark = new Color(117,92,2);
    }
    public static void chooseEyeColorPink(Graphics g) {
        eye = eyePink;
        eyeDark = new Color(130,23,44);
    }
    public static void chooseEyeColorPurple(Graphics g) {
        eye = eyePurple;
        eyeDark = new Color(81,14,114);
    }
    public static void chooseEyeColorRed(Graphics g) {
        eye = eyeRed;
        eyeDark = new Color(119,2,2);
    }
    public static void chooseEyeColorGray(Graphics g) {
        eye = eyeGray;
        eyeDark = new Color(81,81,81);
    }
    public static void drawHair0(Graphics g, int x, int y, double a) {
        //no hair in back
    }
    public static void drawHairBob(Graphics g, int x, int y, double a) {
        //bob
        g.setColor(hair);
        g.fillRect((int)((230+x)*a),(int)((330+y)*a),(int)(188*a),(int)(70*a));
        CubicCurve2D hair = new CubicCurve2D.Float();
        hair.setCurve((280+x)*a,(265+y)*a,(240+x)*a,(265+y)*a,(230+x)*a,(315+y)*a,(230+x)*a,(330+y)*a);
        Graphics2D g2 = (Graphics2D) g;
        g2.fill(hair);
        g.fillOval((int)((230+x)*a),(int)((310+y)*a),(int)(30*a),(int)(40*a));
        CubicCurve2D hair2 = new CubicCurve2D.Float(); //right fill hair
        hair2.setCurve((365+x)*a,(265+y)*a,(405+x)*a,(265+y)*a,(415+x)*a,(315+y)*a,(415+x)*a,(330+y)*a);
        g2.fill(hair2);
        g.fillOval((int)((385+x)*a),(int)((310+y)*a),(int)(30*a),(int)(40*a));
    }
    public static void drawHairAfro(Graphics g, int x, int y, double a) {
        //afro
        g.setColor(hair);
        g.fillOval((int)((225+x)*a),(int)((220+y)*a),(int)(200*a),(int)(181*a)); //base
        //bottom right
        g.fillOval((int)((384+x)*a),(int)((375+y)*a),(int)(13*a),(int)(13*a));
        g.fillOval((int)((392+x)*a),(int)((364+y)*a),(int)(17*a),(int)(17*a));
        g.fillOval((int)((402+x)*a),(int)((358+y)*a),(int)(15*a),(int)(15*a));
        //bottom left
        g.fillOval((int)((255+x)*a),(int)((375+y)*a),(int)(13*a),(int)(13*a));
        g.fillOval((int)((243+x)*a),(int)((364+y)*a),(int)(17*a),(int)(17*a));
        g.fillOval((int)((233+x)*a),(int)((358+y)*a),(int)(15*a),(int)(15*a));
        //top
        g.fillOval((int)((410+x)*a),(int)((317+y)*a),(int)(20*a),(int)(20*a));
        g.fillOval((int)((413+x)*a),(int)((307+y)*a),(int)(20*a),(int)(20*a));
        g.fillOval((int)((415+x)*a),(int)((297+y)*a),(int)(15*a),(int)(15*a));
        g.fillOval((int)((410+x)*a),(int)((287+y)*a),(int)(18*a),(int)(18*a));
        g.fillOval((int)((405+x)*a),(int)((273+y)*a),(int)(20*a),(int)(20*a));
        g.fillOval((int)((400+x)*a),(int)((267+y)*a),(int)(20*a),(int)(20*a));
        g.fillOval((int)((398+x)*a),(int)((257+y)*a),(int)(20*a),(int)(20*a));
        g.fillOval((int)((390+x)*a),(int)((247+y)*a),(int)(18*a),(int)(18*a));
        g.fillOval((int)((380+x)*a),(int)((237+y)*a),(int)(20*a),(int)(20*a));
        g.fillOval((int)((370+x)*a),(int)((233+y)*a),(int)(20*a),(int)(20*a));
        g.fillOval((int)((363+x)*a),(int)((225+y)*a),(int)(18*a),(int)(18*a));
        g.fillOval((int)((351+x)*a),(int)((219+y)*a),(int)(18*a),(int)(18*a));
        g.fillOval((int)((339+x)*a),(int)((215+y)*a),(int)(20*a),(int)(20*a));
        g.fillOval((int)((327+x)*a),(int)((213+y)*a),(int)(20*a),(int)(20*a));
        g.fillOval((int)((322+x)*a),(int)((213+y)*a),(int)(18*a),(int)(18*a));
        g.fillOval((int)((309+x)*a),(int)((212+y)*a),(int)(22*a),(int)(22*a));
        g.fillOval((int)((297+x)*a),(int)((215+y)*a),(int)(20*a),(int)(20*a));
        g.fillOval((int)((287+x)*a),(int)((218+y)*a),(int)(20*a),(int)(20*a));
        g.fillOval((int)((277+x)*a),(int)((221+y)*a),(int)(20*a),(int)(20*a));
        g.fillOval((int)((270+x)*a),(int)((226+y)*a),(int)(20*a),(int)(20*a));
        g.fillOval((int)((258+x)*a),(int)((232+y)*a),(int)(20*a),(int)(20*a));
        g.fillOval((int)((250+x)*a),(int)((240+y)*a),(int)(18*a),(int)(18*a));
        g.fillOval((int)((245+x)*a),(int)((245+y)*a),(int)(15*a),(int)(15*a));
        g.fillOval((int)((238+x)*a),(int)((250+y)*a),(int)(18*a),(int)(18*a));
        g.fillOval((int)((230+x)*a),(int)((260+y)*a),(int)(15*a),(int)(15*a));
        g.fillOval((int)((225+x)*a),(int)((270+y)*a),(int)(20*a),(int)(20*a));
        g.fillOval((int)((221+x)*a),(int)((285+y)*a),(int)(15*a),(int)(15*a));
        g.fillOval((int)((217+x)*a),(int)((295+y)*a),(int)(18*a),(int)(18*a));
        g.fillOval((int)((215+x)*a),(int)((310+y)*a),(int)(18*a),(int)(18*a));
        g.fillOval((int)((217+x)*a),(int)((325+y)*a),(int)(13*a),(int)(13*a));
    }
    public static void drawHead(Graphics g, int x, int y, double a) {
        g.setColor(skin); //skin color
        g.fillOval((int)((250+x)*a),(int)((250+y)*a),(int)(150*a),(int)(150*a));
        //left side fill head
        CubicCurve2D head1 = new CubicCurve2D.Float();
        head1.setCurve((335+x)*a,(250+y)*a,(210+x)*a,(250+y)*a,(230+x)*a,(400+y)*a,(335+x)*a,(400+y)*a);
        Graphics2D g2 = (Graphics2D) g;
        g2.fill(head1);
        CubicCurve2D head2 = new CubicCurve2D.Float();
        head2.setCurve((335+x)*a,(250+y)*a,(210+x)*a,(255+y)*a,(215+x)*a,(415+y)*a,(335+x)*a,(400+y)*a);
        g2.fill(head2);
        CubicCurve2D head3 = new CubicCurve2D.Float();
        head3.setCurve((335+x)*a,(250+y)*a,(215+x)*a,(290+y)*a,(205+x)*a,(405+y)*a,(335+x)*a,(400+y)*a);
        g2.fill(head3);
        
        //right side fill head
        CubicCurve2D head4 = new CubicCurve2D.Float();
        head4.setCurve((315+x)*a,(250+y)*a,(440+x)*a,(250+y)*a,(420+x)*a,(400+y)*a,(315+x)*a,(400+y)*a);
        g2.fill(head4);
        CubicCurve2D head5 = new CubicCurve2D.Float();
        head5.setCurve((315+x)*a,(250+y)*a,(440+x)*a,(255+y)*a,(435+x)*a,(415+y)*a,(315+x)*a,(400+y)*a);
        g2.fill(head5);
        CubicCurve2D head6 = new CubicCurve2D.Float();
        head6.setCurve((315+x)*a,(250+y)*a,(435+x)*a,(290+y)*a,(445+x)*a,(405+y)*a,(315+x)*a,(400+y)*a);
        g2.fill(head6);
        
        //ears
        g.fillOval((int)((215+x)*a),(int)((330+y)*a),(int)(35*a),(int)(35*a));
        g.fillOval((int)((400+x)*a),(int)((330+y)*a),(int)(35*a),(int)(35*a));
        g.setColor(shadeSkin);
        g.fillOval((int)((220+x)*a),(int)((337+y)*a),(int)(23*a),(int)(24*a));
        g.fillOval((int)((407+x)*a),(int)((337+y)*a),(int)(23*a),(int)(24*a));
        g.setColor(skin);
        g.fillOval((int)((218+x)*a),(int)((340+y)*a),(int)(24*a),(int)(23*a));
        g.fillOval((int)((408+x)*a),(int)((340+y)*a),(int)(24*a),(int)(23*a));
        
        //neck
        g.fillRect((int)((315+x)*a),(int)((400+y)*a),(int)(20*a),(int)(10*a));
        g.fillArc((int)((315+x)*a),(int)((400+y)*a),(int)(20*a),(int)(20*a),180,180);
        
        //left blush
        g.setColor(shadeSkin);
        CubicCurve2D blush = new CubicCurve2D.Float();
        blush.setCurve((260+x)*a,(350+y)*a,(260+x)*a,(345+y)*a,(280+x)*a,(345+y)*a,(280+x)*a,(355+y)*a);
        g2.fill(blush);
        CubicCurve2D blush2 = new CubicCurve2D.Float();
        blush2.setCurve((260+x)*a,(350+y)*a,(260+x)*a,(360+y)*a,(280+x)*a,(360+y)*a,(280+x)*a,(355+y)*a);
        g2.fill(blush2);
        
        //right blush
        CubicCurve2D blush3 = new CubicCurve2D.Float();
        blush3.setCurve((370+x)*a,(355+y)*a,(370+x)*a,(345+y)*a,(390+x)*a,(345+y)*a,(390+x)*a,(350+y)*a);
        g2.fill(blush3);
        CubicCurve2D blush4 = new CubicCurve2D.Float();
        blush4.setCurve((370+x)*a,(355+y)*a,(370+x)*a,(360+y)*a,(390+x)*a,(360+y)*a,(390+x)*a,(350+y)*a);
        g2.fill(blush4);
    }
    public static void drawEyes1(Graphics g, int x, int y, double a) {
        //small dots
        g.setColor(eyeDark);
        g.fillOval((int)((265+x)*a),(int)((330+y)*a),(int)(10*a),(int)(10*a)); //left
        g.fillOval((int)((375+x)*a),(int)((330+y)*a),(int)(10*a),(int)(10*a)); //right
    }
    public static void drawEyes2(Graphics g, int x, int y, double a) {
        //sparkly eyes
        g.setColor(eye);
        g.fillOval((int)((265+x)*a),(int)((330+y)*a),(int)(20*a),(int)(20*a)); //left
        g.fillOval((int)((365+x)*a),(int)((330+y)*a),(int)(20*a),(int)(20*a)); //right
        g.setColor(eyeDark);
        g.fillOval((int)((268+x)*a),(int)((334+y)*a),(int)(14*a),(int)(14*a));
        g.fillOval((int)((368+x)*a),(int)((334+y)*a),(int)(14*a),(int)(14*a));
        g.setColor(Color.white);
        g.fillOval((int)((269+x)*a),(int)((334+y)*a),(int)(4*a),(int)(4*a));
        g.fillOval((int)((369+x)*a),(int)((334+y)*a),(int)(4*a),(int)(4*a));
        g.fillOval((int)((278+x)*a),(int)((344+y)*a),(int)(2*a),(int)(2*a));
        g.fillOval((int)((378+x)*a),(int)((344+y)*a),(int)(2*a),(int)(2*a));
    }
    public static void drawEyes3(Graphics g, int x, int y, double a) {
        //eyes closed
        g.setColor(new Color(53,17,20));
        CubicCurve2D eyes = new CubicCurve2D.Float();
        eyes.setCurve((365+x)*a,(345+y)*a,(365+x)*a,(335+y)*a,(385+x)*a,(335+y)*a,(385+x)*a,(335+y)*a);
        Graphics2D g2 = (Graphics2D) g;
        g2.fill(eyes);
        CubicCurve2D eyes2 = new CubicCurve2D.Float();
        eyes2.setCurve((265+x)*a,(335+y)*a,(265+x)*a,(335+y)*a,(285+x)*a,(335+y)*a,(285+x)*a,(345+y)*a);
        g2.fill(eyes2);
    }
    public static void drawEyes4(Graphics g, int x, int y, double a) {
        //lazy smiling eyes
        g.setColor(new Color(53,17,20));
        CubicCurve2D eyes = new CubicCurve2D.Float();
        eyes.setCurve((265+x)*a,(345+y)*a,(265+x)*a,(335+y)*a,(285+x)*a,(325+y)*a,(285+x)*a,(335+y)*a);
        Graphics2D g2 = (Graphics2D) g;
        g2.fill(eyes);
        CubicCurve2D eyes2 = new CubicCurve2D.Float();
        eyes2.setCurve((365+x)*a,(335+y)*a,(365+x)*a,(325+y)*a,(385+x)*a,(335+y)*a,(385+x)*a,(345+y)*a);
        g2.fill(eyes2);
    }
    public static void drawMouth1(Graphics g, int x, int y, double a) {
        //open mouth
        g.setColor(mouth);
        g.fillOval((int)((315+x)*a),(int)((355+y)*a),(int)(20*a),(int)(20*a));
    }
    public static void drawMouth2(Graphics g, int x, int y, double a) {
        //smile
        g.setColor(mouth);
        CubicCurve2D mouthArc = new CubicCurve2D.Float();
        mouthArc.setCurve((300+x)*a,(355+y)*a,(300+x)*a,(350+y)*a,(325+x)*a,(370+y)*a,(325+x)*a,(375+y)*a);
        Graphics2D g2 = (Graphics2D) g;
        g2.fill(mouthArc);
        CubicCurve2D mouthArc2 = new CubicCurve2D.Float();
        mouthArc2.setCurve((325+x)*a,(375+y)*a,(325+x)*a,(370+y)*a,(350+x)*a,(350+y)*a,(350+x)*a,(355+y)*a);
        g2.fill(mouthArc2);
    }
    public static void drawMouth3(Graphics g, int x, int y, double a) {
        //frown mouth
        g.setColor(mouth);
        CubicCurve2D mouthArc = new CubicCurve2D.Float();
        mouthArc.setCurve((300+x)*a,(375+y)*a,(300+x)*a,(370+y)*a,(325+x)*a,(350+y)*a,(325+x)*a,(355+y)*a);
        Graphics2D g2 = (Graphics2D) g;
        g2.fill(mouthArc);
        CubicCurve2D mouthArc2 = new CubicCurve2D.Float();
        mouthArc2.setCurve((325+x)*a,(355+y)*a,(325+x)*a,(350+y)*a,(350+x)*a,(370+y)*a,(350+x)*a,(375+y)*a);
        g2.fill(mouthArc2);
    }
    public static void drawEyebrow0(Graphics g, int x, int y, double a) {
        //no eyebrows
    }
    public static void drawEyebrow1(Graphics g, int x, int y, double a) {
        //angry eyebrows
        g.setColor(hair);
        CubicCurve2D brow = new CubicCurve2D.Float();
        brow.setCurve((260+x)*a,(333+y)*a,(260+x)*a,(321+y)*a,(290+x)*a,(326+y)*a,(290+x)*a,(338+y)*a);
        Graphics2D g2 = (Graphics2D) g;
        g2.fill(brow);
        CubicCurve2D brow2 = new CubicCurve2D.Float();
        brow2.setCurve((360+x)*a,(337+y)*a,(360+x)*a,(325+y)*a,(385+x)*a,(320+y)*a,(390+x)*a,(332+y)*a);
        g2.fill(brow2);
    }
    public static void drawEyebrow2(Graphics g, int x, int y, double a) {
        //worried eyebrows
        g.setColor(hair);
        CubicCurve2D brow = new CubicCurve2D.Float();
        brow.setCurve((360+x)*a,(325+y)*a,(360+x)*a,(313+y)*a,(390+x)*a,(328+y)*a,(390+x)*a,(330+y)*a);
        Graphics2D g2 = (Graphics2D) g;
        g2.fill(brow);
        CubicCurve2D brow2 = new CubicCurve2D.Float();
        brow2.setCurve((260+x)*a,(330+y)*a,(260+x)*a,(328+y)*a,(285+x)*a,(313+y)*a,(290+x)*a,(325+y)*a);
        g2.fill(brow2);
    }
    public static void drawBangsStraight(Graphics g, int x, int y, double a) {
        //straight cut bangs
        g.setColor(hair);
        g.fillRect((int)((300+x)*a),(int)((290+y)*a),(int)(90*a),(int)(30*a));
        g.fillRect((int)((250+x)*a),(int)((290+y)*a),(int)(40*a),(int)(30*a));
        g.setColor(skin);
        g.fillArc((int)((285+x)*a),(int)((290+y)*a),(int)(15*a),(int)(40*a),90,180); //left bang bend
        g.setColor(hair);
        g.fillArc((int)((255+x)*a),(int)((250+y)*a),(int)(140*a),(int)(80*a),0,180); //top of the head
        g.fillArc((int)((290+x)*a),(int)((260+y)*a),(int)(20*a),(int)(60*a),90,180); //right bang bend
        CubicCurve2D hair = new CubicCurve2D.Float();
        hair.setCurve((280+x)*a,(255+y)*a,(260+x)*a,(260+y)*a,(230+x)*a,(315+y)*a,(250+x)*a,(325+y)*a);
        Graphics2D g2 = (Graphics2D) g;
        g2.fill(hair);
    }
    public static void drawBangsAfro(Graphics g, int x, int y, double a) {
        //afro bangs
        g.setColor(hair);
        g.fillArc((int)((255+x)*a),(int)((250+y)*a),(int)(140*a),(int)(70*a),0,180); //top of the head
        g.fillOval((int)((395+x)*a),(int)((320+y)*a),(int)(18*a),(int)(18*a));
        g.fillOval((int)((390+x)*a),(int)((313+y)*a),(int)(18*a),(int)(18*a));
        g.fillOval((int)((383+x)*a),(int)((305+y)*a),(int)(13*a),(int)(13*a));
        g.fillOval((int)((382+x)*a),(int)((295+y)*a),(int)(15*a),(int)(15*a));
        g.fillOval((int)((370+x)*a),(int)((290+y)*a),(int)(18*a),(int)(18*a));
        g.fillOval((int)((360+x)*a),(int)((280+y)*a),(int)(20*a),(int)(20*a));
        g.fillOval((int)((355+x)*a),(int)((275+y)*a),(int)(15*a),(int)(15*a));
        g.fillOval((int)((345+x)*a),(int)((275+y)*a),(int)(15*a),(int)(15*a));
        g.fillOval((int)((330+x)*a),(int)((275+y)*a),(int)(15*a),(int)(15*a));
        g.fillOval((int)((315+x)*a),(int)((275+y)*a),(int)(15*a),(int)(15*a));
        g.fillOval((int)((320+x)*a),(int)((275+y)*a),(int)(15*a),(int)(15*a));
        g.fillOval((int)((300+x)*a),(int)((275+y)*a),(int)(15*a),(int)(15*a));
        g.fillOval((int)((290+x)*a),(int)((275+y)*a),(int)(15*a),(int)(15*a));
        g.fillOval((int)((280+x)*a),(int)((280+y)*a),(int)(15*a),(int)(15*a));
        g.fillOval((int)((270+x)*a),(int)((280+y)*a),(int)(15*a),(int)(15*a));
        g.fillOval((int)((260+x)*a),(int)((285+y)*a),(int)(20*a),(int)(20*a));
        g.fillOval((int)((250+x)*a),(int)((295+y)*a),(int)(18*a),(int)(18*a));
        g.fillOval((int)((243+x)*a),(int)((300+y)*a),(int)(15*a),(int)(15*a));
        g.fillOval((int)((240+x)*a),(int)((310+y)*a),(int)(15*a),(int)(15*a));
        g.fillOval((int)((235+x)*a),(int)((320+y)*a),(int)(18*a),(int)(18*a));
        //fill in blank areas
        g.fillOval((int)((245+x)*a),(int)((279+y)*a),(int)(27*a),(int)(23*a));
        g.fillOval((int)((385+x)*a),(int)((285+y)*a),(int)(33*a),(int)(32*a));
        g.fillOval((int)((375+x)*a),(int)((280+y)*a),(int)(28*a),(int)(18*a));
    }
    public static void drawOutfit(Graphics g, int x, int y, double a) {
        //long droopy sweater
        g.setColor(outfit);
        g.fillRect((int)((305+x)*a),(int)((410+y)*a),(int)(40*a),(int)(70*a));
        g.fillArc((int)((285+x)*a),(int)((410+y)*a),(int)(40*a),(int)(200*a),90,90);
        g.fillArc((int)((325+x)*a),(int)((410+y)*a),(int)(40*a),(int)(200*a),0,90);
    }
}
