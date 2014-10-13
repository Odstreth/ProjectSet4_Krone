import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JLabel;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.JButton;


public class CalcGUI implements PropertyChangeListener, ActionListener {

	private JFrame frmExercise;
	private JTextField futureValueField;
	private double investAmount;
	private int year;
	private double interestRate;
	private Double futureValue;
	private JFormattedTextField investAmountField;
	private JFormattedTextField yearField;
	private JFormattedTextField interestRateField;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalcGUI window = new CalcGUI();
					window.frmExercise.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CalcGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmExercise = new JFrame();
		frmExercise.setTitle("Exercise16_5");
		frmExercise.setBounds(100, 100, 450, 300);
		frmExercise.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmExercise.getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel investmentAmount = new JLabel("Investment Amount");
		frmExercise.getContentPane().add(investmentAmount, "6, 6");
		
		this.investAmountField = new JFormattedTextField();
		frmExercise.getContentPane().add(investAmountField, "16, 6, fill, default");
		investAmountField.setValue(new Double(investAmount));
		investAmountField.addPropertyChangeListener("value", this);
		
		JLabel years = new JLabel("Years");
		frmExercise.getContentPane().add(years, "6, 10");
		
		this.yearField = new JFormattedTextField();
		frmExercise.getContentPane().add(yearField, "16, 10, fill, default");
		yearField.setValue(new Integer(year));
		yearField.addPropertyChangeListener("value", this);
		
		JLabel annualInterestRate = new JLabel("Annual Interest Rate");
		frmExercise.getContentPane().add(annualInterestRate, "6, 14");
		
		this.interestRateField = new JFormattedTextField();
		frmExercise.getContentPane().add(interestRateField, "16, 14, fill, default");
		this.interestRateField.setValue(new Double(interestRate));
		this.interestRateField.addPropertyChangeListener("value", this);
		
		JLabel futureValue = new JLabel("Future Value");
		frmExercise.getContentPane().add(futureValue, "6, 18");
		
		this.futureValueField = new JTextField();
		futureValueField.setText("");
		frmExercise.getContentPane().add(futureValueField, "16, 18, fill, default");
		futureValueField.setColumns(10);
		
		JButton calculate = new JButton("Calculate");
		frmExercise.getContentPane().add(calculate, "16, 20");
		calculate.addActionListener(this);
	}

	@Override
	public void propertyChange(PropertyChangeEvent e) {
		Object source = e.getSource();
		if (source.equals(investAmountField)) {
	        investAmount = ((Number)investAmountField.getValue()).doubleValue();
	    } 
		else if (source == yearField) {
	        year = ((Number)yearField.getValue()).intValue();
	    } 
		else if (source == interestRateField) {
	        interestRate = ((Number)interestRateField.getValue()).doubleValue();
	    }

	    futureValue = CalcEngine.calc(investAmount, year, interestRate);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		futureValue = CalcEngine.calc(investAmount, year, interestRate);
		futureValueField.setText(futureValue.toString());
		
	}
}
