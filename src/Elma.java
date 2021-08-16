import java.awt.Color;
import java.awt.Graphics;

public class Elma {
	
private int xKordinasyonu,yKordinasyonu,genislik,yukseklik;
	
	public Elma(int xKordinasyonu,int yKordinasyonu,int titleSize) {
		this.xKordinasyonu=xKordinasyonu;
		this.yKordinasyonu=yKordinasyonu;
		genislik=titleSize;
		yukseklik=titleSize;
	}
    public void hareketet() {
	
    }
    public void draw(Graphics g) {
    	g.setColor(Color.GREEN);
    	g.fillRect(xKordinasyonu*genislik, yKordinasyonu*yukseklik, genislik, yukseklik);
    }
	public int getxKordinasyonu() {
		return xKordinasyonu;
	}
	public void setxKordinasyonu(int xKordinasyonu) {
		this.xKordinasyonu = xKordinasyonu;
	}
	public int getyKordinasyonu() {
		return yKordinasyonu;
	}
	public void setyKordinasyonu(int yKordinasyonu) {
		this.yKordinasyonu = yKordinasyonu;
	}
    
    
}
