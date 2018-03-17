package MediaPlayer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MediaPlayer extends JPanel implements ActionListener {

	JFrame window = new JFrame("Media player");
	JLabel info = new JLabel("Welcome!.");
	JButton addButton = new JButton("Chose a song");
	JButton playButton = new JButton("Play");
	JButton stopButton = new JButton("Stop");
	Font customFont = new Font("", Font.BOLD, 20);
	JComboBox list = new JComboBox();
	JFileChooser browser = new JFileChooser();
	FileNameExtensionFilter filter = new FileNameExtensionFilter("wav Sound", "wav");
	int returnValue;
	String[] musics = new String[10];
	File selectedFile;
	int index = 0;
	File sound;
	AudioInputStream ais;
	Clip clip;

	MediaPlayer() {
		this.setBackground(Color.BLACK);
		window.add(this);

		addButton.addActionListener(this);
		playButton.addActionListener(this);
		stopButton.addActionListener(this);

		info.setFont(new Font("", Font.ITALIC, 20));
		window.add(info, BorderLayout.PAGE_END);

		// Text storlek

		addButton.setFont(customFont);
		stopButton.setFont(customFont);
		playButton.setFont(customFont);

		// Färgerna
		addButton.setBackground(Color.black);
		addButton.setForeground(Color.YELLOW);

		playButton.setBackground(Color.black);
		playButton.setForeground(Color.green);

		stopButton.setBackground(Color.BLACK);
		stopButton.setForeground(Color.red);

		list.setBackground(Color.black);
		list.setForeground(Color.CYAN);

		// Höjd och bredd begränsningar
		window.add(addButton, BorderLayout.LINE_START);
		window.add(playButton, BorderLayout.CENTER);
		window.add(stopButton, BorderLayout.LINE_END);
		window.add(list, BorderLayout.PAGE_START);

		browser.setFileFilter(filter);

		// Öppnar fönstret
		window.setSize(400, 200);
		window.setLocation(100, 100);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);

	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == addButton) {

			returnValue = browser.showOpenDialog(window);

			if (returnValue == browser.APPROVE_OPTION)

			{
				selectedFile = browser.getSelectedFile();
				musics[index] = selectedFile.toString();
				// JOptionPane.showMessageDialog(null, selectedFile.toString());
				list.addItem("Låt - " + index);
				index++;

			}

		}

		else if (ae.getSource() == playButton) {
			try {

				if (list.getSelectedIndex() == 0)

				{
					sound = new File(musics[list.getSelectedIndex()]);
					ais = AudioSystem.getAudioInputStream(sound);
					clip = AudioSystem.getClip();
					clip.open(ais);
					clip.start();
				}

				else if (list.getSelectedIndex() == 2) {

					sound = new File(musics[list.getSelectedIndex()]);
					ais = AudioSystem.getAudioInputStream(sound);
					clip = AudioSystem.getClip();
					clip.open(ais);
					clip.start();
				}

				else if (list.getSelectedIndex() == 3) {

					sound = new File(musics[list.getSelectedIndex()]);
					ais = AudioSystem.getAudioInputStream(sound);
					clip = AudioSystem.getClip();
					clip.open(ais);
					clip.start();
				}

			}

			catch (Exception e) {
				JOptionPane.showMessageDialog(null, e);
			}

		}

		else if (ae.getSource() == stopButton) {
			clip.close();

		}

	}

}
