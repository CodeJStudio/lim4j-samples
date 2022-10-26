package com.codejstudio.lim.samples;

import java.io.FileNotFoundException;

import com.codejstudio.lim.common.exception.LIMException;
import com.codejstudio.lim.pojo.Root;
import com.codejstudio.lim.pojo.argument.Argument;
import com.codejstudio.lim.pojo.argument.Validity;
import com.codejstudio.lim.pojo.condition.Condition;
import com.codejstudio.lim.pojo.statement.Definition;
import com.codejstudio.lim.pojo.statement.HypotheticalProposition;
import com.codejstudio.lim.pojo.statement.JudgedStatement;

/**
 * sample: Example18 
 * in "Theory of Logical Information Model & Logical Information Network" 
 * from https://github.com/jhjiang/lim_lin
 * 
 * @author <ul><li>Jeffrey Jiang</li></ul>
 * @see     com.codejstudio.lim.pojo.Root
 * @see     com.codejstudio.lim.pojo.argument.Argument
 * @see     com.codejstudio.lim.pojo.argument.Validity
 * @see     com.codejstudio.lim.pojo.condition.Condition
 * @see     com.codejstudio.lim.pojo.statement.Definition
 * @see     com.codejstudio.lim.pojo.statement.HypotheticalProposition
 * @see     com.codejstudio.lim.pojo.statement.JudgedStatement
 * @since   lim4j_v1.0.0
 */
public class Example18 {
	
	private static final String CLASS_NAME = Example18.class.getSimpleName();
	
	private static final String INPUT_FILE_PATH = "/samples/" + CLASS_NAME + ".xml";
	
	private static final String OUTPUT_FILE_PATH = "";//e.g. "d:/" + CLASS_NAME + ".xml"

	public static void main(String[] args) throws LIMException, FileNotFoundException {
		doXmlMarshal();
//		doXmlUnmarshal();
	}

	private static void doXmlMarshal() throws LIMException, FileNotFoundException {
		Argument a1 = new Argument("∵ax²+bx+c=0, ∴x=(-b±√(b²-4ac))/2a");
		Argument a2 = new Argument("∵ax²+bx+c=0, ∴x²+(b/a)x+(c/a)=0");
		Argument a3 = new Argument("∵x²+(b/a)x+(c/a)=0, ∴x²+2(b/2a)x+(b/2a)²=-(c/a)+(b/2a)²");
		Argument a4 = new Argument("∵x²+2(b/2a)x+(b/2a)²=-(c/a)+(b/2a)², ∴(x+(b/2a))²=(b²-4ac)/4a²");
		Argument a5 = new Argument("∵(x+(b/2a))²=(b²-4ac)/4a², ∴x+(b/2a)=√(b²-4ac)/2a");
		Argument a6 = new Argument("∵x+(b/2a)=√(b²-4ac)/2a, ∴x=(-b±√(b²-4ac))/2a");

		JudgedStatement js1 = new Definition("ax²+bx+c=0");
		JudgedStatement js2 = new Definition("x=(-b±√(b²-4ac))/2a");
		JudgedStatement js3 = new Definition("x²+(b/a)x+(c/a)=0");
		JudgedStatement js4 = new Definition("x²+2(b/2a)x+(b/2a)²=-(c/a)+(b/2a)²");
		JudgedStatement js5 = new Definition("(x+(b/2a))²=(b²-4ac)/4a²");
		JudgedStatement js6 = new Definition("x+(b/2a)=±√(b²-4ac)/2a");
		JudgedStatement js7 = new HypotheticalProposition("If ac=bc, and c≠0, then a=b. (cancellation law of multiplication)");
		JudgedStatement js8 = new HypotheticalProposition("If a+c=b+c, then a=b. (cancellation law of addition)");
		JudgedStatement js9 = new Definition("x²+2kx+k²=(x+k)², k∈R");
		JudgedStatement js10 = new HypotheticalProposition("If a²=b², then a=±b.");
		
		Condition cd1 = new Condition("a,b,c∈R, a≠0");

		a2.addEvidence(js1, js7);
		a2.addConclusion(js3);
		a2.addCondition(cd1);
		a2.setValidity(new Validity(1));
		a3.addEvidence(js3, js8);
		a3.addConclusion(js4);
		a3.addCondition(cd1);
		a3.setValidity(new Validity(1));
		a4.addEvidence(js4, js9);
		a4.addConclusion(js5);
		a4.addCondition(cd1);
		a4.setValidity(new Validity(1));
		a5.addEvidence(js5, js10);
		a5.addConclusion(js6);
		a5.addCondition(cd1);
		a5.setValidity(new Validity(1));
		a6.addEvidence(js6, js8);
		a6.addConclusion(js2);
		a6.addCondition(cd1);
		a6.setValidity(new Validity(1));

		a1.addEvidence(js1);
		a1.addConclusion(js2);
		a1.addCondition(cd1);
		a1.addSubArgument(a2, a3, a4, a5, a6);
		a1.setValidity(new Validity(1));

		Root root = new Root(a1);

		
		
		root.marshalToXml(true, System.out);
		
		//set OUTPUT_FILE_PATH first, before opening below comment code
//		root.marshalToXml(true, new BufferedOutputStream(new FileOutputStream(OUTPUT_FILE_PATH)));
	}

	private static void doXmlUnmarshal() throws LIMException {
		Root root = Root.unmarshalFromXml(Example18.class.getResource(INPUT_FILE_PATH));
		root.redecorate();
		root.marshalToXml(true, System.out);
	}

}
