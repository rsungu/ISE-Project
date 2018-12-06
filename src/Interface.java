import javax.swing.JFrame;
import javax.swing.JLabel;


public class Interface {
	private JFrame f;
	private displayVeld feit, segment1, segment2, segmentDisplay, predikaat, realatie1, relatie2;
	
	public FeitInvoeren Feit;
	public SegmentInvoeren Segment1, Segment2;
	
	public Interface() {  
		f = new JFrame("Jan Pieters analysator"); 
		f.setSize(950, 800); 
		f.setResizable(false);

		Setup();
		PaginaLaden();
		Feit.PaginaLaden();

		f.setLayout(null);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	}    
	
	private void Setup() {
		Feit = new FeitInvoeren(f,this);
		Segment1 = new SegmentInvoeren(1, f, this);
		Segment2 = new SegmentInvoeren(2, f, this);
		
		Feit.variabelenToevoegen(Segment1, Segment2);
		Segment1.variabelenToevoegen(Feit, Segment2);
		Segment2.variabelenToevoegen(Feit, Segment1);		
	}
	
	public void PaginaLaden() {
		//Feit
		JLabel feitLabel = new JLabel();
		feitLabel.setText("Het feit");
		feitLabel.setBounds(50, -10, 300, 50);
		f.add(feitLabel);
		feit = new displayVeld(50, 25, 850, 30);	
		feit.setText(Feit.getFeit());
		f.add(feit);		
		
		//Segment 1
		JLabel segment1Label = new JLabel();		
		segment1Label.setText("Segment 1");
		segment1Label.setBounds(50, 40, 300, 50);
		f.add(segment1Label);
		segment1 = new displayVeld(50, 75, 400, 90);
		segment1.setText(Segment1.getSegment());
		f.add(segment1);
		
		//Segment 2
		JLabel segment2Label = new JLabel();		
		segment2Label.setText("Segment 2");
		segment2Label.setBounds(500, 40, 300, 50);
		f.add(segment2Label);
		segment2 = new displayVeld(500, 75, 400, 90);
		segment2.setText(Segment2.getSegment());
		f.add(segment2);	
		
		//Predikaat
		JLabel predikaatLabel = new JLabel();		
		predikaatLabel.setText("Predikaat");
		predikaatLabel.setBounds(50, 150, 850, 50);
		f.add(predikaatLabel);
		displayVeld predikaatText = new displayVeld(50, 185, 850, 60);
		f.add(predikaatText);
		
		//Relatietype 1
		JLabel relatie1Label = new JLabel();		
		relatie1Label.setText("Relatietype 1");
		relatie1Label.setBounds(50, 230, 850, 50);
		f.add(relatie1Label);
		displayVeld relatie1Text = new displayVeld(50, 265, 850, 60);
		f.add(relatie1Text);
		
		//Relatietype 2
		JLabel relatie2Label = new JLabel();		
		relatie2Label.setText("Relatietype 2");
		relatie2Label.setBounds(50, 310, 850, 50);
		f.add(relatie2Label);
		displayVeld relatie2Text = new displayVeld(50, 345, 850, 60);
		f.add(relatie2Text);
		
		f.revalidate();
		f.repaint();
	}
	
	public static void main(String[] args) {    
	    new Interface();    
	}    
 }