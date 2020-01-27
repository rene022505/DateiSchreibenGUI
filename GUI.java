import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;

/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 21.01.2020
 * @author rene052502
 */

public class GUI extends JFrame {
	private static final long serialVersionUID = 1L;
	private JLabel jLabel1 = new JLabel();
	private JLabel jLabel2 = new JLabel();
	private JTextField dateiname = new JTextField();
	private JTextArea exportText = new JTextArea("");
	private JTextArea zeilenNr = new JTextArea("");
	private JScrollPane jTextArea1ScrollPane = new JScrollPane(exportText);
	private JButton anzeigeLoeschen = new JButton();
	private JButton inDateiSchreiben = new JButton();
	private JButton ausDateiLesen = new JButton();
	private JButton ausDateiLesenLine = new JButton();

	public GUI() {
		super();
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		int frameWidth = 559;
		int frameHeight = 572;
		setSize(frameWidth, frameHeight);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (d.width - getSize().width) / 2;
		int y = (d.height - getSize().height) / 2;
		setLocation(x, y);
		setTitle("GUI");
		setResizable(false);
		Container cp = getContentPane();
		cp.setLayout(null);

		jLabel1.setBounds(15, 19, 110, 20);
		jLabel1.setText("Dateiname:");
		cp.add(jLabel1);
		jLabel2.setBounds(15, 160, 110, 20);
		jLabel2.setText("Zeile:");
		cp.add(jLabel2);
		dateiname.setBounds(133, 18, 390, 20);
		cp.add(dateiname);
		zeilenNr.setBounds(60, 160, 59, 20);
		cp.add(zeilenNr);
		jTextArea1ScrollPane.setBounds(134, 57, 392, 452);
		cp.add(jTextArea1ScrollPane);
		anzeigeLoeschen.setBounds(12, 65, 107, 25);
		anzeigeLoeschen.setText("Text loeschen");
		anzeigeLoeschen.setMargin(new Insets(2, 2, 2, 2));
		anzeigeLoeschen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				exportText.setText("");
			}
		});
		cp.add(anzeigeLoeschen);
		inDateiSchreiben.setBounds(12, 96, 107, 25);
		inDateiSchreiben.setText("Text in Datei");
		inDateiSchreiben.setMargin(new Insets(2, 2, 2, 2));
		inDateiSchreiben.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				if (!dateiname.getText().equals("")) {
					try {
						rotzFileStream.writeTofile(dateiname.getText(), exportText.getText());
					} catch (IOException e) {
						System.out.println(e);
					}
				}
			}
		});
		cp.add(inDateiSchreiben);

		ausDateiLesen.setBounds(12, 130, 107, 25);
		ausDateiLesen.setText("Text aus Datei");
		ausDateiLesen.setMargin(new Insets(2, 2, 2, 2));
		ausDateiLesen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				if (!dateiname.getText().equals("")) {
					try {
						exportText.setText(rotzFileStream.readFromFile(dateiname.getText()));
					} catch (IOException e) {
						System.out.println(e);
					}
				}
			}
		});
		cp.add(ausDateiLesen);

		ausDateiLesenLine.setBounds(12, 185, 107, 25);
		ausDateiLesenLine.setText("Zeile aus Datei");
		ausDateiLesenLine.setMargin(new Insets(2, 2, 2, 2));
		ausDateiLesenLine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				if (!dateiname.getText().equals("") && !zeilenNr.getText().equals("")) {
					try {
						exportText.setText(rotzFileStream.readLineFromFile(dateiname.getText(), Integer.parseInt(zeilenNr.getText()) - 1));
					} catch (IOException e) {
						System.out.println(e);
					}
				}
			}
		});
		cp.add(ausDateiLesenLine);

		setVisible(true);
	}

	public static void main(String[] args) {
		new GUI();
	}
}
