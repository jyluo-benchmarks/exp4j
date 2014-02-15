package net.objecthunter.exp4j.function;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

import net.objecthunter.exp4j.expression.ExpressionBuilder;

public class BigDecimalFunctionsTest {
	@Test
	public void testFunction1() throws Exception {
		Function<BigDecimal> sine = Functions.getBuiltinFunction("sin", ExpressionBuilder.MODE_BIGDECIMAL);
		BigDecimal tmp = sine.apply(new BigDecimal(Math.PI));
		assertEquals(BigDecimal.ZERO,tmp);
		tmp = sine.apply(BigDecimal.ZERO);
		assertEquals(BigDecimal.ZERO,tmp);
		tmp = sine.apply(new BigDecimal(Math.PI));
		assertEquals(BigDecimal.ONE,tmp);
	}

	@Test
	public void testFunction2() throws Exception {
		Function<BigDecimal> sqrt = Functions.getBuiltinFunction("sqrt", ExpressionBuilder.MODE_BIGDECIMAL);
		BigDecimal tmp = sqrt.apply(new BigDecimal(100));
		assertEquals(0,tmp.compareTo(BigDecimal.TEN));
		tmp = sqrt.apply(BigDecimal.ONE);
		assertEquals(0,tmp.compareTo(BigDecimal.ONE));
		tmp = sqrt.apply(BigDecimal.ZERO);
		assertEquals(0,tmp.compareTo(BigDecimal.ZERO));
		tmp = sqrt.apply(new BigDecimal(9));
		assertEquals(0,tmp.compareTo(new BigDecimal(3d)));
		tmp = sqrt.apply(new BigDecimal(9));
		assertEquals(0,tmp.compareTo(new BigDecimal(3d)));
		tmp = sqrt.apply(new BigDecimal(2));
		System.out.println(tmp);
		assertEquals(0,tmp.compareTo(new BigDecimal("1.414213562373095048801688724209698")));
	}
	@Test(expected=ArithmeticException.class)
	public void testFunction3() throws Exception {
		Function<BigDecimal> sqrt = Functions.getBuiltinFunction("sqrt", ExpressionBuilder.MODE_BIGDECIMAL);
		BigDecimal tmp = sqrt.apply(new BigDecimal(-1));
	}
}
