package br.com.alura.rh.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import br.com.alura.rh.ValidacaoException;
import br.com.alura.rh.model.Funcionario;

public class ValidacaoPeriocidadeEntreReajuste implements ValidacaoReajuste {
	
	public void validar(Funcionario funcionario, BigDecimal aumento ) {
		
		LocalDate dataUltimoReajuste = funcionario.getDataUltimoReajuste();
		LocalDate dataAtual = LocalDate.now();
		long mesesDoUltimoReajuste = ChronoUnit.MONTHS.between(dataUltimoReajuste, dataAtual);
		if (mesesDoUltimoReajuste < 6) {
			throw new ValidacaoException("Intervalo entre reajuste deve ser no minino 6 meses!");
		}
	}

}
