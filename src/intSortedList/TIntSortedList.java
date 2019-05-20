package intSortedList;

import auxiliary.ListException;
import auxiliary.Terminal;
import intList.IntList;

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
			String command = Terminal.getString("Command (if/il/df/dl/x):");
			switch ("idx".indexOf(command)) {
			case 0: //i
				l.insert(Terminal.getInt("New value:"));
				break;
			case 2: //d
				try {
					l.delete(Terminal.getInt("New value:"));
				} catch (ListException e) {
					Terminal.put("Illegal operation ...");
				}
				break;
			case 8: //x
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
