package main.java.com.premiumminds.internship.screenlocking;

import java.util.ArrayList;
import java.util.List;
/**
 * Mock Class used to test the implementation (as a regular java application, of the methods found 
 * on class ScreenLockinPattern and their functionability. This class can be ran as a regular 
 * java Application, and return the total count as a regular Integer (instead of Future<Integer>
 * @author Guilherme Salgueiro
 *
 */
public class Countingtesting {

	public static void main(String[] args) {
		Countingtesting ct = new Countingtesting();
		int[] ponto = {2, 2};
		int result = ct.countPatterns(ponto, 2);
		
		System.out.println(result);
		System.out.println("Estou a correr bem");

	}
	public List<String> whatsForbiden(int[] point) {
		List<String> forbiden = new ArrayList<>();
		if (point[0] == 1) {
			forbiden.add("N");
		} else if (point[0] == 2) {
			forbiden.add("NN");
			forbiden.add("SS");
		} else if (point[0] == 3) {
			forbiden.add("S");
		}
		
		if (point[1] == 1) {
			forbiden.add("O");
		} else if (point[1] == 2) {
			forbiden.add("EE");
			forbiden.add("OO");
		} else if (point[1] == 3) {
			forbiden.add("E");
		}
		
		return forbiden;
	}
	public List<int[]> possibleWays(int[] point, List<int[]> history) {
		
		List<String> forbiden = this.whatsForbiden(point);
		System.out.println("neste ponto, as direcoes proibidas sao: " + forbiden);
		System.out.println("o historico atual: " + history);
		
		List<String> directions = new ArrayList<>();
		directions.add("N");
		directions.add("S");
		directions.add("E");
		directions.add("O");
		directions.add("NE");
		directions.add("NNE");
		directions.add("NEE");
		directions.add("NO");
		directions.add("NNO");
		directions.add("NOO");
		directions.add("SE");
		directions.add("SSE");
		directions.add("SEE");
		directions.add("SO");
		directions.add("SSO");
		directions.add("SOO");
		

		for (String elem: forbiden) {
			int i = 0;
			while ( i < directions.size()) {
				if (directions.contains(elem)) {
					directions.removeIf(s -> s.contains(elem));
				} else {
					i++;
				}
			}
		}
		System.out.println("as direcoes permitidas sao apenas: " + directions);
		
		List<int[]> moves = new ArrayList<>();
		for (String x: directions) {
			int[] move = point;
			for (char d: x.toCharArray()) {
				if (d == 'N') {
					move[0] = move[0] - 1;
				} else if (d == 'S') {
					move[0] = move[0] + 1;
				} else if (d == 'E') {
					move[1] = move[1] + 1;
				} else if (d == 'O') {
					move[1] = move[1] - 1;
				}
			}
			if (!history.contains(move)) {
				moves.add(move);
			}
		}
		System.out.println("O array de movimentos possiveis: ");
		
		return moves;
	}
	
	public int countPatternsAux(int[] point, int length, List<int[]> history) {
		if (length == 1) {
			return 1;
		}
		int patterns = 0;
		List<int[]> pWays = this.possibleWays(point, history);
		history.add(point);
		
		for (int[] nMove: pWays) {
			patterns += this.countPatternsAux(nMove, length-1, history);
		}
		
		return patterns;
		
	}
	
	public int countPatterns(int[] point, int length) {
		
		List<int[]> history = new ArrayList<>();
		return this.countPatternsAux(point, length, history);
		
	}
}
