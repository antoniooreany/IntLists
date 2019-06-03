package Kratzer.intSortedList;

import Kratzer.Terminal;

public class TIntSortedList {

	public static void main(String[] args) {

		IntSortedList l = new IntSortedList(); 
		boolean terminate = false;

		while (!terminate) {
			// Show the current state of the structure
			if (l.isEmpty()) {
				Terminal.put("The list is empty ...");
			} else {
				Terminal.put("Contents: " + l.toString());
				Terminal.put("Size:     " + l.size());
				Terminal.put("First:    " + l.firstElement());
				Terminal.put("Last:     " + l.lastElement());
			}
			// Enter and execute command
			String command = Terminal.getString("Command (i/d/x):");
			switch ("idx".indexOf(command)) {
			case 0: //insert
				l.insert(Terminal.getInt("New value:"));
				break;
			case 1: //delete
				try {
					l.delete(Terminal.getInt("Value to kill:"));
				} catch (ListException e) {
					Terminal.put("Illegal operation ...");
				}
				break;
			case 2: //x
				terminate = true;
				break;
			default:
				Terminal.put("... no comprendo nada ...");
				break;
			}
		}

		Terminal.put("Ciao!");
	}
}
