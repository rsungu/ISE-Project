import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

public class SegmentInvoeren {
	private FeitInvoeren feit;
	private SegmentInvoeren andereSegment;
	private JFrame f;
	private Interface i;
	
	private displayVeld segmentDisplay;
	private int SegmentComponentNr, SegmentNummer;
	private String segmentString;
	private String Component[], EtOfAtt[], Naam[], Id[];
	private JComboBox<String> invoerEtOfAtt;

	public SegmentInvoeren (int SegmentNummer, JFrame f, Interface i) {
		this.SegmentNummer = SegmentNummer;
		this.f = f;
		this.i = i;
				
		//Variabele declareren
		SegmentComponentNr = 0;
		Component = new String[10];
		EtOfAtt = new String[10];
		Naam = new String[10];
		Id = new String[10];
	}
	
	public void variabelenToevoegen(FeitInvoeren feit, SegmentInvoeren andereSegment) {
		this.feit = feit;
		this.andereSegment = andereSegment;
	}
	
	public void PaginaLaden() {
		//Label 
		JLabel SegmentDisplayLabel = new JLabel();		
		SegmentDisplayLabel.setText("Segment " + SegmentNummer + ": ");
		SegmentDisplayLabel.setBounds(75, 395, 800, 50);
		f.add(SegmentDisplayLabel);
		//Textveld
		segmentDisplay = new displayVeld (75, 430, 800, 30);
		segmentDisplay.setText(segmentString);
		segmentDisplay.setFont(segmentDisplay.getFont().deriveFont(20f));
		f.add(segmentDisplay);
		
		//Label
		JLabel invoerComponentLabel = new JLabel();		
		invoerComponentLabel.setText("Selecteer component " + (SegmentComponentNr+1) + " voor segment " + SegmentNummer + ":");
		invoerComponentLabel.setBounds(75, 445, 800, 50);
		f.add(invoerComponentLabel);
		//Textveld
		JTextField invoerComponentText = new JTextField ();
		invoerComponentText.setBounds(75, 480, 800, 30);
		//invoerComponentText.setText(segmentString);
		invoerComponentText.setEditable(false);
		invoerComponentText.setBackground(Color.WHITE);
		f.add(invoerComponentText);
		
		//Label EtOfAtt
		JLabel invoerEtOfAttLabel = new JLabel();		
		invoerEtOfAttLabel.setText("Entiteit of Attribuut?");
		invoerEtOfAttLabel.setBounds(75, 495, 800, 50);
		f.add(invoerEtOfAttLabel);
		// create an empty combo box with items of type String
		invoerEtOfAtt = new JComboBox<String>();
		//Items toevoegen
		invoerEtOfAtt.addItem("ET");
		invoerEtOfAtt.addItem("Att");
		
		invoerEtOfAtt.setBackground(Color.WHITE);
		invoerEtOfAtt.setSelectedIndex(0);
		invoerEtOfAtt.setEnabled(true);
		invoerEtOfAtt.setBounds(75, 530, 800, 30);
		f.add(invoerEtOfAtt);
		
		//Label Naam
		JLabel invoerNaamLabel = new JLabel();		
		invoerNaamLabel.setText("Voer de naam van component " + (SegmentComponentNr+1) + " in:");
		invoerNaamLabel.setBounds(75, 545, 800, 50);
		f.add(invoerNaamLabel);
		//Textveld
		JTextField invoerNaamText = new JTextField ();
		invoerNaamText.setBounds(75, 580, 800, 30);
		//invoerNaam1Text.setText(Naam1Text.getText());
		f.add(invoerNaamText);
		
		//Label ID
		JLabel invoerIdLabel = new JLabel();		
		invoerIdLabel.setText("Voer het ID voor component " + (SegmentComponentNr+1) + " in:");
		invoerIdLabel.setBounds(75, 595, 800, 50);
		f.add(invoerIdLabel);
		//Textveld
		JTextField invoerIdText = new JTextField ();
		invoerIdText.setBounds(75, 630, 800, 30);
		//invoerId1Text.setText(Id1Text.getText());
		f.add(invoerIdText);
		
		//Component vorige button
		JButton cVorigeKnop = new JButton();    
		cVorigeKnop.setText("Vorige");
		cVorigeKnop.setBounds(275, (f.getHeight() - 125), 100, 30);   
		if (SegmentComponentNr != 0) {
			f.add(cVorigeKnop);	
		}
		
		//Component volgende button
		JButton cVolgendeKnop = new JButton();    
		cVolgendeKnop.setText("Opslaan");
		cVolgendeKnop.setBounds((f.getWidth() - 425), (f.getHeight() - 125), 100, 30);   
		f.add(cVolgendeKnop);
		
		//Vorige button
		JButton vorigeKnop = new JButton();    
		vorigeKnop.setText("Vorige");
		vorigeKnop.setBounds(125, (f.getHeight() - 125), 100, 50);   
		f.add(vorigeKnop);	
		//Volgende button
		JButton volgendeKnop = new JButton();    
		volgendeKnop.setText("Volgende");
		volgendeKnop.setBounds((f.getWidth() - 275), (f.getHeight() - 125), 100, 50);  
		if (SegmentComponentNr > 0) {
			f.add(volgendeKnop);
		}
		
		//EventListener display
		segmentDisplay.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				if (segmentDisplay.getSelectedText() != null) {
					invoerComponentText.setText(segmentDisplay.getSelectedText());
				}
				
			}

		});
		
		
		//EventListener Vorige
		cVorigeKnop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) { 
				//Gegevens opslaan
				invoerComponentText.setText(Component[SegmentComponentNr]); 
				//invoerEtOfAtt1.setSelectedItem(EtOfAtt1[Segment1ComponentNr]);
				invoerNaamText.setText(Naam[SegmentComponentNr]);
				invoerIdText.setText(Id[SegmentComponentNr]);
				
				SegmentComponentNr--;
				Component[SegmentComponentNr] = null;
				EtOfAtt[SegmentComponentNr] = null;
				Naam[SegmentComponentNr] = null;
				Id[SegmentComponentNr] = null;
				//Alles verwijderen
				f.getContentPane().removeAll();
				i.PaginaLaden();
				//Volgende window
				segmentString = segmentOpmaak();
				PaginaLaden();
				}
		});
		
		//Eventlistner cVolgendeKnop
		cVolgendeKnop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) { 
				
				String TempComponent = invoerComponentText.getText();
				String TempEtOfAtt = (String) invoerEtOfAtt.getSelectedItem();
				String TempNaam = invoerNaamText.getText();
				String TempId = invoerIdText.getText();
				
				if (!TempComponent.isEmpty() && !TempNaam.isEmpty() && !TempId.isEmpty()) {
					//Gegevens opslaan
					Component[SegmentComponentNr] = invoerComponentText.getText();
					EtOfAtt[SegmentComponentNr] = (String) invoerEtOfAtt.getSelectedItem();
					Naam[SegmentComponentNr] = invoerNaamText.getText();
					Id[SegmentComponentNr] = invoerIdText.getText();
					
					SegmentComponentNr++;
					//Alles verwijderen
					f.getContentPane().removeAll();
					//Volgende window
					segmentString = segmentOpmaak();
					i.PaginaLaden();
					PaginaLaden();
					}
			}
		});
		
		//EventListener Vorige
		vorigeKnop.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) { 	
					//Alles verwijderen
					f.getContentPane().removeAll();
					i.PaginaLaden();
					if (SegmentNummer == 1) {
						feit.PaginaLaden();
					} else if (SegmentNummer == 2) {
						andereSegment.PaginaLaden();
					}
				}
		});
		//EventListener Volgende
		volgendeKnop.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) { 
					//Variabelen opslaan
					//segmentString = segmentOpmaak();

					//Alles verwijderen
					f.getContentPane().removeAll();
					i.PaginaLaden();
					
					
					if (SegmentNummer == 1) {
						andereSegment.PaginaLaden();
					} else if (SegmentNummer == 2) {
						//Predikaat
					}
					
					
					
					
					
					//Als dit segment2 is moet het verder gaan naar predikaat.
					
					
					
							
			
				}
		});
		
		if (SegmentComponentNr == 10) {
			f.remove(invoerComponentLabel);
			f.remove(invoerComponentText);
			f.remove(invoerNaamLabel);
			f.remove(invoerNaamText);
			f.remove(invoerEtOfAttLabel);
			f.remove(invoerEtOfAtt);
			f.remove(invoerIdLabel);
			f.remove(invoerIdText);
			f.remove(cVolgendeKnop);
		}
		//Frame updaten
		f.revalidate();
		f.repaint();
	}
	
	public void setSegment(String segment) {
		segmentString = segment;
	}
	
	public String getSegment() {
		return segmentString;
	}
	
	private String segmentOpmaak() {	
		String segment;
		//segment = "<span style=\"text-decoration: underline\">" + segmentString + "</span>";
		segment = segmentString + "\n";
		for (int i = 0; i < SegmentComponentNr; i++) {
			segment +=  EtOfAtt[i] + " " + Naam[i] + "\n" + "ID: " + Id[i] + "\n";
		}
		return segment;
	}
	
}
