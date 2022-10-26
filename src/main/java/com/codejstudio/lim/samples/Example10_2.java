package com.codejstudio.lim.samples;

import com.codejstudio.lim.common.exception.LIMException;
import com.codejstudio.lim.pojo.Root;
import com.codejstudio.lim.pojo.argument.MixedHypotheticalSyllogism;
import com.codejstudio.lim.pojo.condition.HypotheticalCondition;
import com.codejstudio.lim.pojo.statement.HypotheticalProposition;
import com.codejstudio.lim.pojo.statement.JudgedStatement;
import com.codejstudio.lim.pojo.statement.Proposition;
import com.codejstudio.lim.pojo.statement.Statement;

/**
 * sample: Example10_2 
 * in "Theory of Logical Information Model & Logical Information Network"
 * from https://github.com/jhjiang/lim_lin
 * 
 * @author <ul><li>Jeffrey Jiang</li></ul>
 * @see     com.codejstudio.lim.pojo.Root
 * @see     com.codejstudio.lim.pojo.argument.MixedHypotheticalSyllogism
 * @see     com.codejstudio.lim.pojo.condition.HypotheticalCondition
 * @see     com.codejstudio.lim.pojo.statement.HypotheticalProposition
 * @see     com.codejstudio.lim.pojo.statement.JudgedStatement
 * @see     com.codejstudio.lim.pojo.statement.Proposition
 * @see     com.codejstudio.lim.pojo.statement.Statement
 * @since   lim4j_v1.0.0
 */
public class Example10_2 {
	
	private static final String CLASS_NAME = Example10_2.class.getSimpleName();
	
	private static final String INPUT_FILE_PATH = "/samples/" + CLASS_NAME + ".xml";
	
	private static final String OUTPUT_FILE_PATH = "";//e.g. "d:/" + CLASS_NAME + ".xml"

	public static void main(String[] args) throws LIMException {
		doXmlMarshal();
//		doXmlUnmarshal();
	}

	private static void doXmlMarshal() throws LIMException {
		MixedHypotheticalSyllogism mhsy1 = new MixedHypotheticalSyllogism("③ If the second soldier tells the truth, then this is the gate of life. "
				+ "The second soldier tells the truth. Therefore, this is the gate of life.");

		HypotheticalProposition hpp1 = new HypotheticalProposition("If the second soldier tells the truth, then this is the gate of life.");

		Statement s1 = new Statement("the second soldier tells the truth");

		JudgedStatement js1 = new Proposition("this is the gate of life");
		JudgedStatement js2 = new Proposition("the second soldier tells the truth");
		JudgedStatement js3 = new Proposition("This is the gate of life.");

		HypotheticalCondition hcd1 = new HypotheticalCondition(s1);

		hpp1.setAntecedentAndConsequent(hcd1, js1);

		mhsy1.setElementsOfSyllogism(hpp1, js2, js3);
		mhsy1.addCondition(hcd1);

		Root root = new Root(mhsy1);

		
		
		root.marshalToXml(true, System.out);
		
		//set OUTPUT_FILE_PATH first, before opening below comment code
//		root.marshalToXml(true, new BufferedOutputStream(new FileOutputStream(OUTPUT_FILE_PATH)));
	}

	private static void doXmlUnmarshal() throws LIMException {
		Root root = Root.unmarshalFromXml(Example10_2.class.getResource(INPUT_FILE_PATH));
		root.redecorate();
		root.marshalToXml(true, System.out);
	}

}
