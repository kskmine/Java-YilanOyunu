import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;

public class Oyunpaneli extends JPanel implements Runnable,KeyListener{
	
    private static  final long serialVersionUID=1L;
	
	public static final int GENISLIK=400, YUKSEKLIK=400;
	
	private Thread thread;
	
	private boolean running=false;
	
	private boolean sag= true,sol =false, yukari=false,asagi=false;
	
	private Yilan y;
	private ArrayList<Yilan>yilan;
	
	private Elma elma;
	private ArrayList<Elma> elmaa;
	
	private Random rnd;
	
	private int xKordinasyonu=10,yKordinasyonu=10,size=5;
	private int hareketler=0;
	
	
	
	public Oyunpaneli() {
		setFocusable(true);
		
		addKeyListener(this);
		setPreferredSize(new Dimension(GENISLIK,YUKSEKLIK));
		
		rnd=new Random();
		
		yilan = new ArrayList<Yilan>();
		elmaa=new ArrayList<Elma>();
		
		
		baslat();
	}
	
    public void hareketet() {
        if (yilan.size() == 0) {
            y = new Yilan(xKordinasyonu, yKordinasyonu, 10);
            yilan.add(y);
        }
        if(elmaa.size() == 0) {
            int xKordinasyonu = rnd.nextInt(39);
            int yKordinasyonu = rnd.nextInt(39);
            
            elma = new Elma(xKordinasyonu, yKordinasyonu, 10);
            elmaa.add(elma);
        }
        
        for(int i = 0; i < elmaa.size(); i++) {
            if(xKordinasyonu == elmaa.get(i).getxKordinasyonu() && 
                    yKordinasyonu == elmaa.get(i).getyKordinasyonu()) {
                size++;
                elmaa.remove(i);
                i++;
            }
        }
        
        for(int i =0; i < yilan.size(); i++) {
            if(xKordinasyonu == yilan.get(i).getxKordinasyonu() && 
                    yKordinasyonu == yilan.get(i).getyKordinasyonu()) {
                if(i != yilan.size() - 1) {
                    baslat();
                }
            }
        }
        if(xKordinasyonu < 0 || xKordinasyonu > 39 || yKordinasyonu < 0 || yKordinasyonu > 39) {
            durdur();
        }
        
        
        hareketler++;
        
        if(hareketler > 250000) {
            if(sag) xKordinasyonu++;
            if(sol) xKordinasyonu--;
            if(yukari) yKordinasyonu--;
            if(asagi) yKordinasyonu++;
            
            hareketler = 0;
            
            y = new Yilan(xKordinasyonu, yKordinasyonu, 10);
            yilan.add(y);
            
            if(yilan.size() > size) {
                yilan.remove(0);
            }
        }
    }
 
    public void paint(Graphics g) {
        g.clearRect(0, 0, GENISLIK, YUKSEKLIK);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, GENISLIK, YUKSEKLIK);
        
        g.setColor(Color.BLACK);
        for (int i = 0; i < GENISLIK / 10; i++) {
            g.drawLine(i * 10, 0, i * 10, YUKSEKLIK);
        }
        for (int i = 0; i < YUKSEKLIK / 10; i++) {
            g.drawLine(0, i * 10, GENISLIK, i * 10);
        }
 
        for (int i = 0; i < yilan.size(); i++) {
            yilan.get(i).draw(g);
        }
        for(int i = 0; i < elmaa.size(); i++) {
            elmaa.get(i).draw(g);
        }
 
    }
 
    public void baslat() {
        running = true;
        thread = new Thread(this);
        thread.start();
    }
 
    public void durdur() {
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
 
    public void run() {
        while (running) {
        	hareketet();
            repaint();
        }
    }
 
    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_RIGHT && !sol) {
        	yukari = false;
        	asagi = false;
            sag = true;
        }
        if(key == KeyEvent.VK_LEFT && !sag) {
        	yukari = false;
        	asagi = false;
            sol = true;
        }
        if(key == KeyEvent.VK_UP && !asagi) {
        	sol = false;
            sag = false;
            yukari = true;
        }
        if(key == KeyEvent.VK_DOWN && !yukari) {
        	sol = false;
            sag = false;
            asagi = true;
        }
    }
    @Override
    public void keyReleased(KeyEvent arg0) {    
    }
    public void keyTyped(KeyEvent arg0) {   
    }    
}

