package br.com.alura.financas.teste;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.alura.financas.modelo.Categoria;
import br.com.alura.financas.modelo.Conta;
import br.com.alura.financas.modelo.Movimentacao;
import br.com.alura.financas.modelo.TipoMovimentacao;
import br.com.alura.financas.util.JPAUtil;

public class TesteMovimentacoesComCategoria {
	
	public static void main(String[] args) {
		
		Categoria categoria = new Categoria("Viagem");		
		Categoria categoria1 = new Categoria("Negócio");
		
		Conta conta = new Conta();
		conta.setId(2);
		
		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setData(Calendar.getInstance());
		movimentacao.setDescriacao("Viagem à Portugal");
		movimentacao.setTipo(TipoMovimentacao.SAIDA);
		movimentacao.setValor(new BigDecimal("300.00"));
		movimentacao.setCategoria(Arrays.asList(categoria, categoria1));
		
		movimentacao.setConta(conta);
		
		Movimentacao movimentacao1 = new Movimentacao();
		movimentacao1.setData(Calendar.getInstance());
		movimentacao1.setDescriacao("Viagem à Paris");
		movimentacao1.setTipo(TipoMovimentacao.SAIDA);
		movimentacao1.setValor(new BigDecimal("100.00"));
		movimentacao1.setCategoria(Arrays.asList(categoria, categoria1));
		
		movimentacao1.setConta(conta);
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		em.persist(categoria);
		em.persist(categoria1);		
		em.persist(movimentacao);
		em.persist(movimentacao1);
		
		em.getTransaction().commit();
		em.close();
	
	}

}
