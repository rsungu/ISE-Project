import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class FeitInvoeren {
	private SegmentInvoeren Segment1, Segment2;
	private String feit;
	private JFrame f;
	private Interface i;
	
	FeitInvoeren(JFrame f, Interface i) {
		this.f = f;
		this.i = i;
	}
	
	public void PaginaLaden() {
		//Label
		JLabel invoerFeitLabel = new JLabel();		
		invoerFeitLabel.setText("Voer het feit in:");
		invoerFeitLabel.setBounds(75, 415, 800, 50);
		f.add(invoerFeitLabel);
		//Textveld
		JTextField invoerFeitText = new JTextField ();
		invoerFeitText.setBounds(75, 450, 800, 30);
		invoerFeitText.setText(feit);
		f.add(invoerFeitText);
		
		//Label
		JLabel invoerSegment1Label = new JLabel();		
		invoerSegment1Label.setText("Voer segment 1 in:");
		invoerSegment1Label.setBounds(75, 465, 800, 50);
		f.add(invoerSegment1Label);
		//Textveld
		JTextField invoerSegment1Text = new JTextField ();
		invoerSegment1Text.setBounds(75, 500, 800, 30);
		//invoerSegment1Text.setText(feit.getText());
		f.add(invoerSegment1Text);
		
		//Label
		JLabel invoerSegment2Label = new JLabel();		
		invoerSegment2Label.setText("Voer segment 2 in:");
		invoerSegment2Label.setBounds(75, 515, 800, 50);
		f.add(invoerSegment2Label);
		//Textveld
		JTextField invoerSegment2Text = new JTextField ();
		invoerSegment2Text.setBounds(75, 550, 800, 30);
		//invoerSegment2Text.setText(feit.getText());
		f.add(invoerSegment2Text);
		
		//Volgende button
		JButton volgendeKnop = new JButton();    
		volgendeKnop.setText("Volgende");
		volgendeKnop.setBounds((f.getWidth() - 275), (f.getHeight() - 125), 100, 50);   
		f.add(volgendeKnop);
		
		//EventListener
		volgendeKnop.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					feit = invoerFeitText.getText();
					
					//Controle of segmenten goed zin ingevuld
					if (feitInvoerControle(feit, invoerSegment1Text.getText(), invoerSegment2Text.getText())) {	
						
						Segment1.setSegment(invoerSegment1Text.getText());
						Segment2.setSegment(invoerSegment2Text.getText());
						
						f.getContentPane().removeAll();
						i.PaginaLaden();
						Segment1.PaginaLaden();
					}
				}
		});
		f.revalidate();
		f.repaint();
	}
	
	public String getFeit() {
		return feit;
	}
	
	public void variabelenToevoegen(SegmentInvoeren Segment1, SegmentInvoeren Segment2) {
		this.Segment1 = Segment1;
		this.Segment2 = Segment2;
	}
	
	private boolean feitInvoerControle(String feit, String segment1, String segment2) {
		if (!feit.toLowerCase().contains(segment1.toLowerCase())) {
			return false;
		} else if (!feit.toLowerCase().contains(segment2.toLowerCase())) {
			return false;
		} else {
			return true;
		}
	}
}
