package miniproject.Face;
import java.lang.*;
import java.util.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.googlecode.javacv.cpp.opencv_core.CvMemStorage;
import com.googlecode.javacv.cpp.opencv_core.CvRect;
import com.googlecode.javacv.cpp.opencv_core.CvSeq;
import com.googlecode.javacv.cpp.opencv_core.IplImage;
import static com.googlecode.javacv.cpp.opencv_core.cvClearMemStorage;
import static com.googlecode.javacv.cpp.opencv_core.cvGetSeqElem;
import static com.googlecode.javacv.cpp.opencv_core.cvLoad;
import com.googlecode.javacv.cpp.opencv_highgui;
import com.googlecode.javacv.cpp.opencv_highgui.CvCapture;
import static com.googlecode.javacv.cpp.opencv_objdetect.CV_HAAR_DO_CANNY_PRUNING;
import com.googlecode.javacv.cpp.opencv_objdetect.CvHaarClassifierCascade;
import static com.googlecode.javacv.cpp.opencv_objdetect.cvHaarDetectObjects;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jaydutt
 */

public class FaceCapture implements Runnable
{
    String path="C:\\Users\\admin\\Documents\\NetBeansProjects\\miniProject\\images";
    JLabel label;
   
    public Thread t=null;
    volatile boolean flag;  
   
    static CvHaarClassifierCascade cascade = new CvHaarClassifierCascade(cvLoad("C:\\opencv-master\\data\\haarcascades\\haarcascade_frontalcatface.xml"));
       
    FaceRecognition recognize;
    
    DefaultTableModel model;
    
    public FaceCapture(JLabel temp,DefaultTableModel model)
    {
        this.model=model;
        recognize=new FaceRecognition(path);
        recognize.train();
        label=temp;
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
        System.out.println("ok");
        CvCapture capture=opencv_highgui.cvCreateCameraCapture(0);
        System.out.println("ok");
        IplImage img=opencv_highgui.cvQueryFrame(capture);
        System.out.println("ok");
        while((img=opencv_highgui.cvQueryFrame(capture))!=null && flag )
        {
            System.out.println("ok");
            detect(img);
        }
        System.out.println("ok");
    }
    
    /**
     *
     * @param src
     * @return
     */
    public void detect(IplImage src)
    {
        System.out.println("ok1");
        BufferedImage bimg=src.getBufferedImage();
        System.out.println("ok1");
        Graphics2D graphics=(Graphics2D) bimg.getGraphics();
        System.out.println("ok21");
        graphics.setPaint(Color.red);
        System.out.println("ok1");
        graphics.setFont(new Font("Arial Black", Font.BOLD, 20));
                        System.out.println("ok1");
                        
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
                        
                        BufferedImage img=bimg.getSubimage(r.x(),r.y(),r.width(),r.height());
                        
                        IplImage ip=IplImage.createFrom(img);
                        String name=recognize.predict(ip);
                        
                        checkAndAdd(name);        
                        graphics.drawString(name, r.x(), r.y());
                        graphics.drawRect(r.x(), r.y(), r.width(), r.height());
                }  
                label.setIcon(new ImageIcon(bimg));
	}
    
    private void checkAndAdd(String name)
    {
        String temp;
        int count=model.getRowCount();
        for(int i=0;i<count;i++)
        {
            temp=model.getValueAt(i,0).toString();
            if(temp.equals(name))
            {
                return;
            }
        }
        model.addRow(new Object[]{name,"not confirmed"});
    }
   
}