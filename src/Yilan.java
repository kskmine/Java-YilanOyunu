import java.awt.Color;
import java.awt.Graphics;

public class Yilan {
	
	private int xKordinasyonu,yKordinasyonu,genislik,yukseklik;
	
	public Yilan(int xKordinasyonu,int yKordinasyonu,int titleSize) {
		this.xKordinasyonu=xKordinasyonu;
		this.yKordinasyonu=yKordinasyonu;
		genislik=titleSize;
		yukseklik=titleSize;
	}
    public void hareketet() {
	
    }
    public void draw(Graphics g) {
    	g.setColor(Color.WHITE);
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
