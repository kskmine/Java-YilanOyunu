import javax.swing.JFrame;

public class Main {
	
	public Main() {
		JFrame frame=new JFrame();
		Oyunpaneli oyunpaneli= new Oyunpaneli();
		
		frame.add(oyunpaneli);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("YILANOYUNU");
		
		frame.setResizable(false);
		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
	
	public static void main(String[] args) {
		new Main();
	}
}
