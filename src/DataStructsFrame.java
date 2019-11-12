import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class DataStructsFrame extends JFrame {
	int[] numbert;
	int[] numbert2;
	ListPanel unorderedList;
	public DataStructsFrame(String title, int[] numbers, int[] numbers2) {
		super(title);

		final JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

		 ArrayList<ListItem> list = arrayToList(numbers, numbers2);
		 
		
	
		 unorderedList = new ListPanel("Unordered List");
		unorderedList.setDiameter(75);
		unorderedList.addItems(list);

		final ListPanel orderedList = new ListPanel("Ordered List");
		orderedList.setDiameter(100);

		JTextField changeText = new JTextField("Change Values?");
		JButton sortButton = new JButton("Sort List A");
		JButton sortButton2 = new JButton("Sort List B");
		JButton addToList = new JButton("Add to List");
		sortButton.setSize(30, 10);
		addToList.setSize(30, 10);
		sortButton2.setSize(30, 10);
		changeText.setSize(100, 100);
	    addToList.setAlignmentX(CENTER_ALIGNMENT);
	    
		
		sortButton.setAlignmentX(CENTER_ALIGNMENT);
		sortButton2.setAlignmentX(CENTER_ALIGNMENT);
		changeText.setAlignmentX(CENTER_ALIGNMENT);
	
		

		sortButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				Collections.sort(list);
				orderedList.addItems(list);
				panel.add(orderedList);
				sortButton.setEnabled(false);
				pack();
			}
		});
		
		sortButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				Collections.sort(list, Collections.reverseOrder());
				orderedList.addItems(list);
				panel.add(orderedList);
				sortButton2.setEnabled(false);
				pack();
			}
		});
		
		addToList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String getTxt = changeText.getText();
				 numbert = new int[1];
				 numbert2 = new int[1];
				String[] str = getTxt.split(" ");
				for(int i =0; i < str.length; i++) {
					if(i==0) {
					numbert[0] = Integer.parseInt(str[i]);
					System.out.println(numbert[i]);
					}
					else {
						numbert2[0] =  Integer.parseInt(str[i]);
					}
				}
				
				changeText.setText("");
				ArrayList <ListItem> nee = new ArrayList<ListItem>();
				ListItem ne = new ListItem(numbert[0], numbert2[0]);
				nee.add(ne);
				unorderedList.addItems(nee);
				orderedList.addItems(nee);
				
				panel.add(unorderedList);
			pack();
				
				
			}
		});
		
	

		panel.add(unorderedList);
		panel.add(sortButton);
		panel.add(sortButton2);
		
		panel.add(changeText);
		panel.add(addToList);
		add(panel);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}

	private ArrayList<ListItem> arrayToList(int[] numbers, int[] numbers2) {
		ArrayList<ListItem> list = new ArrayList<ListItem>();

		for (int i = 0; i < numbers.length; i++) {
			ListItem item = new ListItem(numbers[i], numbers2[i]);
			list.add(item);
		}

		return list;
	}
}
