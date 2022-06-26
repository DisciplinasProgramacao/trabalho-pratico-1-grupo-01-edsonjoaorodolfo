package algorithms;

import java.util.List;

import entities.Lamina;

public class Backtracking {

	public static int backtrackingRecursivo(int tamanho, int reducao, List<Lamina> lista) {

		int c1 = 0;
		int c2 = 0;
		int c3 = 0;
		int tam = tamanho - reducao;
		if (tam > 6) {
			c3 += backtrackingRecursivo(tam, 3, lista);
			c2 += backtrackingRecursivo(tam, 2, lista);
			c1 += backtrackingRecursivo(tam, 1, lista);
		} else if (tam == 6) {
			c2 += backtrackingRecursivo(tam, 2, lista);
			c1 += backtrackingRecursivo(tam, 1, lista);
		} else if (tam == 5) {
			c1 += backtrackingRecursivo(tam, 1, lista);
		} else if (tam == 4) {
			if (reducao == 3) {
				return Lamina.encontraLaminaPorLargura(lista, tam + 3).getCustoReducao3();
			} else if (reducao == 2) {
				return Lamina.encontraLaminaPorLargura(lista, tam + 2).getCustoReducao2();
			} else if (reducao == 1) {
				return Lamina.encontraLaminaPorLargura(lista, tam + 1).getCustoReducao1();
			}
		}
		if (c3 != 0 && c3 <= c2 && c3 <= c1) {
			return c3;
		} else if (c2 != 0 && c2 <= c1) {
			return c2;
		}
		return c1;

	}

}
