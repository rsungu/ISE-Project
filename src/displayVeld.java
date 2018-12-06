import java.awt.Color;

import javax.swing.JTextPane;

public class displayVeld extends JTextPane {
	
	public displayVeld (int x, int y, int width, int height) {
		this.setBounds(x, y, width, height);
		this.setEditable(false);
		this.setBackground(Color.white);

	}
}


