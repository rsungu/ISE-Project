import java.awt.Color;

import javax.swing.JTextPane;

public class DisplayVeld extends JTextPane {
	
	public DisplayVeld () {
		this.setEditable(false);
		this.setBackground(Color.white);
		this.setFont(this.getFont().deriveFont(26f));
	}
}