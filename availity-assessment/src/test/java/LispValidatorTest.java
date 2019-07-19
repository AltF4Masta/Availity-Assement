package test.java;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.java.LispValidator;

class LispValidatorTest {
	LispValidator lisp = new LispValidator();

	@Test
	void testShouldPass() {
		boolean result = lisp.validate("()");
		assertTrue(result);
		result = lisp.validate("()()()()");
		assertTrue(result);
		result = lisp.validate("(vnd((fjkva(VFDASvf )SDF fd))sd f(vf))");
		assertTrue(result);
		result = lisp.validate("((((()))))");
		assertTrue(result);
		result = lisp.validate("vdfbahjv()vdcsavdna");
		assertTrue(result);
		result = lisp.validate("fvsdvfsV(VFV(DFVSAFS(FVA)VVF0v0fvsfvsv))");
		assertTrue(result);
	}
	
	@Test
	void testShouldFail() {
		boolean result = lisp.validate(")");
		assertFalse(result);
		result = lisp.validate("(");
		assertFalse(result);
		result = lisp.validate(")(");
		assertFalse(result);
		result = lisp.validate("(vnd((fjkva(VFDASvf )SDF fd))sd");
		assertFalse(result);
		result = lisp.validate("((((())");
		assertFalse(result);
		result = lisp.validate("vdfbahjv()vdcsavdna)");
		assertFalse(result);
		result = lisp.validate("()fvsdv))(fsV(VFV(DFVSAFS(FVA)VVF0v0fv)sfvsv))");
		assertFalse(result);
	}
}
