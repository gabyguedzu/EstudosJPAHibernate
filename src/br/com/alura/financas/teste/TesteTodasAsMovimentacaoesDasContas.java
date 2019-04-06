package br.com.alura.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.alura.financas.modelo.Conta;
import br.com.alura.financas.util.JPAUtil;

public class TesteTodasAsMovimentacaoesDasContas {
	
	public static void main(String[] args) {

		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		String jpql = "select c from Conta c join fetch c.movimentacoes";
		Query query = em.createQuery(jpql);
		
		List<Conta> todasAsContas = query.getResultList();
		
		for (Conta conta : todasAsContas) {
			System.out.println("Titular" + conta.getTitular());
			System.out.println("Movimentaçôes: ");
			System.out.println(conta.getMovimentacoes());
		}
		
		em.getTransaction().commit();
		em.close();
	}

}
