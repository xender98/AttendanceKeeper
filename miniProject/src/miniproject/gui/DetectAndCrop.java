package miniproject.gui;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import static com.googlecode.javacv.cpp.opencv_core.CV_AA;
import com.googlecode.javacv.cpp.opencv_core.CvMemStorage;
import com.googlecode.javacv.cpp.opencv_core.CvRect;
import com.googlecode.javacv.cpp.opencv_core.CvScalar;
import com.googlecode.javacv.cpp.opencv_core.CvSeq;
import com.googlecode.javacv.cpp.opencv_core.IplImage;
import static com.googlecode.javacv.cpp.opencv_core.cvClearMemStorage;
import static com.googlecode.javacv.cpp.opencv_core.cvGetSeqElem;
import static com.googlecode.javacv.cpp.opencv_core.cvLoad;
import static com.googlecode.javacv.cpp.opencv_core.cvPoint;
import static com.googlecode.javacv.cpp.opencv_core.cvRectangle;
import com.googlecode.javacv.cpp.opencv_highgui;
import com.googlecode.javacv.cpp.opencv_highgui.CvCapture;
import static com.googlecode.javacv.cpp.opencv_objdetect.CV_HAAR_DO_CANNY_PRUNING;
import com.googlecode.javacv.cpp.opencv_objdetect.CvHaarClassifierCascade;
import static com.googlecode.javacv.cpp.opencv_objdetect.cvHaarDetectObjects;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author jaydutt
 */

public class DetectAndCrop implements Runnable
{
    String path="C:\\Users\\jaydutt\\Documents\\NetBeansProjects\\miniProject\\images";
    JLabel label;
    JLabel cropImage;
    Thread t;
    BufferedImage saveCroped;
    volatile boolean flag; 
    static CvHaarClassifierCascade cascade = new CvHaarClassifierCascade(cvLoad("C:\\opencv\\sources\\data\\haarcascades\\haarcascade_frontalface_alt.xml"));
    
    public DetectAndCrop(JLabel temp,JLabel crop)
    {
        System.out.println("Entered in the face capture constucter");
        label=temp;
        cropImage=crop;
    }
    
    public void start()
    {
        flag=true;
        t=new Thread(this);
        t.start();
    }

    public void stop()
    {
        flag=false;
    }
    
    @Override
    public void run() {
        CvCapture capture=opencv_highgui.cvCreateCameraCapture(0);
        
        IplImage img=opencv_highgui.cvQueryFrame(capture);
        
        while((img=opencv_highgui.cvQueryFrame(capture))!=null && flag )
        {
            img=detect(img);  
         
            BufferedImage bufferedimage=img.getBufferedImage();
            ImageIcon icon=new ImageIcon(bufferedimage);
            label.setIcon(icon);
  
        }
    }
    
    /**
     *
     * @param src
     * @return
     */
    public IplImage detect(IplImage src)
    {
		CvMemStorage storage = CvMemStorage.create();
		CvSeq sign = cvHaarDetectObjects(
				src,
				cascade,
				storage,
				1.5,
				3,
				CV_HAAR_DO_CANNY_PRUNING);
		cvClearMemStorage(storage);
		int total_Faces = sign.total();		
		for(int i = 0; i < total_Faces; i++){
			CvRect r = new CvRect(cvGetSeqElem(sign, i));

			cvRectangle (
					src,
					cvPoint(r.x(), r.y()),
					cvPoint(r.width() + r.x(), r.height() + r.y()),
					CvScalar.RED,
					2,
					CV_AA,
					0);

		
                        saveCroped=src.getBufferedImage().getSubimage(r.x(),r.y(),r.width(),r.height());
                        ImageIcon icon=new ImageIcon(saveCroped);
                        cropImage.setIcon(icon);
                }  
		return src;
	}
    
    public boolean save(String name,JLabel label)
    {
        if(name.isEmpty())
        {
            name="unknown";
        }
        
        if(saveCroped==null)
        {
            return false;
        }
        
        File outputfile = new File(path+"\\"+name+".jpg");
        try{
        ImageIO.write(saveCroped, "jpg", outputfile);
        System.out.println("Image saved");
        ImageIcon imgIcon=new ImageIcon(saveCroped);
        label.setIcon(imgIcon);
        }    
        catch(IOException e)
        {
            System.out.println("IOException thrown");
        }
        return true;
    }
}