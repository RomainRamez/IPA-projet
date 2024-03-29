import java.awt.image.ColorModel;
import java.awt.color.ColorSpace;
import javax.media.jai.JAI;
import javax.media.jai.RenderedOp;
import javax.swing.JFrame;
/*
 * La classe principale à executer pour que le programme se lance
 */
public class Main {
    public static void main(String[] args) {
        Traitement t;
        //DETECTION SI RGB OU GREY (CHANGE_IMG ?)
        String fn = "D:\\Cours\\MaM3\\IPA\\IPA-projet\\ProjetIPA\\images\\Accueil.png";
        RenderedOp ropimage;
        ropimage = JAI.create("fileload", fn);
        ColorModel cm = ropimage.getColorModel();
        if (cm.getColorSpace().getType() == ColorSpace.TYPE_RGB) {
            t = new TraitementRGB(fn);
        }
        else{
            t = new TraitementGrey(fn);
            }
        t.setImgName(fn);
        // JUSQUE LA
        Interface interface1;
    JFrame frame = new JFrame("Traitement d'image");
    interface1 = new Interface(t.getWidth(),t.getTabRGB(),fn);
    TextFieldTest convolM=new TextFieldTest(frame,t,interface1);
    Menu menu = new Menu(t,interface1,frame,convolM);
    menu.build();
    frame.add(interface1);
    frame.pack();
    frame.setSize(t.getWidth()+300,t.getHeight()+200);
    frame.setVisible(true);
}
}
