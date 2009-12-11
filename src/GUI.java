import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class GUI implements MouseListener {
	PlayStream player = new PlayStream();
	JButton btn_play = new JButton("Play");
	JButton btn_stop = new JButton("Stop");
	JPanel content = new JPanel(new GridBagLayout());
	JFrame window = new JFrame("Streaming media player");
	static GridBagConstraints c;
	public GUI() {
		c = new GridBagConstraints();
		
		content.add(btn_play,c);
		
		c.gridx = 1;
		content.add(btn_stop, c);
		
		btn_play.addMouseListener(this);
		btn_stop.addMouseListener(this);
		
		
		window.setContentPane(content);
	    window.setLocation(100,100);
	    window.setSize(250,250);
	    window.setVisible(true);
	}
	public void mouseClicked(MouseEvent event) {
		if(event.getSource() == btn_play) {
			player.play();
		} else if (event.getSource() == btn_stop) {
			player.close();
		}
	}
	public void mouseEntered(MouseEvent arg0) {}
	public void mouseExited(MouseEvent arg0) {}
	public void mousePressed(MouseEvent arg0) {}
	public void mouseReleased(MouseEvent arg0) {}

}
