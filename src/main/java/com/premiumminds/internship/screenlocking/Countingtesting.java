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
		int ponto = 3;
		int result = ct.countPatterns(ponto, 3);
		
		System.out.println(result);
		System.out.println("Estou a correr bem");

	}
	public List<String> whatsForbiden(int firstpoint) {
		List<String> forbiden = new ArrayList<>();
		if (firstpoint == 1 || firstpoint == 2 || firstpoint == 3) {
			forbiden.add("N");
		} else if (firstpoint == 4 || firstpoint == 5 || firstpoint == 6) {
			forbiden.add("NN");
			forbiden.add("SS");
		} else if (firstpoint == 7 || firstpoint == 8 || firstpoint == 9) {
			forbiden.add("S");
		}
		
		if (firstpoint == 1 || firstpoint == 4 || firstpoint == 7) {
			forbiden.add("O");
		} else if (firstpoint == 2 || firstpoint == 5 || firstpoint == 8) {
			forbiden.add("EE");
			forbiden.add("OO");
		} else if (firstpoint == 3 || firstpoint == 6 || firstpoint == 9) {
			forbiden.add("E");
		}
		
		return forbiden;
	}
	public List<Integer> possibleWays(int firstpoint, List<Integer> history) {
		
		List<String> forbiden = this.whatsForbiden(firstpoint);
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
		
		List<Integer> moves = new ArrayList<>();
		for (String x: directions) {
			int move = firstpoint;
			for (char d: x.toCharArray()) {
				if (d == 'N' && move >= 1 && move <= 9) {
					move = move - 3;
				} else if (d == 'S' && move >= 1 && move <= 9) {
					move = move + 3;
				} else if (d == 'E' && move >= 1 && move <= 9) {
					move = move + 1;
				} else if (d == 'O' && move >= 1 && move <= 9) {
					move = move - 1;
				}
			}
			if (!history.contains(move)) {
				moves.add(move);
			}
		}
		System.out.println("O array de movimentos possiveis: " + moves);
		
		return moves;
	}
	
	public int countPatternsAux(int point, int length, List<Integer> history) {
		if (length == 1) {
			return 1;
		}
		int patterns = 0;
		List<Integer> pWays = this.possibleWays(point, history);
		history.add(point);
		
		for (int nMove: pWays) {
			patterns += this.countPatternsAux(nMove, length-1, history);
		}
		
		return patterns;
		
	}
	
	public int countPatterns(int point, int length) {
		
		List<Integer> history = new ArrayList<>();
		return this.countPatternsAux(point, length, history);
		
	}
}
