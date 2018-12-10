import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

public class PopUp {
	
	private String FeitTekst;
	private String segmentString[] = new String[2];
	
	PopUp() {
		segmentString[0] = "";
		segmentString[1] = "";

		FeitTekst = "";
		
		feit();
	}
	
	public void feit() {
		
		DisplayVeld feit = new DisplayVeld();
		feit.setEditable(true);
		
		Object[] input = {
				"Voer het feit in dat u wilt analyseren.", feit
		};
		
		Object[] buttons = {
				"Volgende"
		};

		while (FeitTekst.equals("")) {			
			JOptionPane.showOptionDialog(null, 
					input, 
					"Segment selecteren", 
					JOptionPane.YES_OPTION, 
					JOptionPane.PLAIN_MESSAGE,
					null,
					buttons,
					null
					);
			FeitTekst = feit.getText();
		}
		segment(0);
	}
	
	public void segment(int segmentNummer) {
		//Segment selecteren
		DisplayVeld selectVeld = new DisplayVeld();
		selectVeld.setEditable(false);
		selectVeld.setText(FeitTekst);
		DisplayVeld segment = new DisplayVeld();
		segment.setEditable(false);
		
//		//Drop down menu
//		JComboBox<String> invoerEtOfAtt = new JComboBox<String>();
//		//Items toevoegen
//		invoerEtOfAtt.addItem("ET");
//		invoerEtOfAtt.addItem("Att");
//
//		invoerEtOfAtt.setBackground(Color.WHITE);
//		invoerEtOfAtt.setSelectedIndex(0);
//		invoerEtOfAtt.setEnabled(true);
//		
//		//Naam
//		DisplayVeld Naam = new DisplayVeld ();
//		Naam.setEditable(true);

		//EventListener display
		selectVeld.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			@Override
			public void mouseExited(MouseEvent e) {
			}
			@Override
			public void mousePressed(MouseEvent e) {
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				if (selectVeld.getSelectedText() != null) {
					segment.setText(selectVeld.getSelectedText());
				}	
			}
		});
		
		Object[] input = {
				"Selecteer het segment:", selectVeld,
				"Uw geselecteerde segment:", segment
//				,
//				"Selecteer entiteit of attribuut", invoerEtOfAtt,
//				"Kies een naam", Naam
		};
		
		Object[] buttons = {
				"Terug",
				"Volgende"
		};
		
		while (segmentString[segmentNummer].equals("")) {
			JOptionPane.showOptionDialog(null, 
					input,
					"Segment selecteren",
					JOptionPane.YES_NO_OPTION,
					JOptionPane.PLAIN_MESSAGE,
					null,
					buttons,
					null
					);
			segmentString[segmentNummer] = segment.getText();
		}
	}
	
	public String getFeitTekst() {
		return FeitTekst;
	}

	public void setFeitTekst(String feitTekst) {
		FeitTekst = feitTekst;
	}

	public String getSegmentString(int waarde) {
		return segmentString[waarde];
	}

	public void setSegmentString(String[] segmentString) {
		this.segmentString = segmentString;
	}

}
