package com.codejstudio.lim.samples;

import java.io.FileNotFoundException;

import com.codejstudio.lim.common.exception.LIMException;
import com.codejstudio.lim.pojo.Root;
import com.codejstudio.lim.pojo.argument.Argument;
import com.codejstudio.lim.pojo.condition.Condition;
import com.codejstudio.lim.pojo.relation.BaseRelation;
import com.codejstudio.lim.pojo.relation.EquivalenceRelation;
import com.codejstudio.lim.pojo.statement.JudgedStatement;
import com.codejstudio.lim.pojo.statement.Proposition;
import com.codejstudio.lim.pojo.statement.Statement;

/**
 * sample: Example17 
 * in "Theory of Logical Information Model & Logical Information Network"
 * from https://github.com/jhjiang/lim_lin
 * 
 * @author <ul><li>Jeffrey Jiang</li></ul>
 * @see     com.codejstudio.lim.pojo.Root
 * @see     com.codejstudio.lim.pojo.argument.Argument
 * @see     com.codejstudio.lim.pojo.condition.Condition
 * @see     com.codejstudio.lim.pojo.relation.BaseRelation
 * @see     com.codejstudio.lim.pojo.relation.EquivalenceRelation
 * @see     com.codejstudio.lim.pojo.statement.JudgedStatement
 * @see     com.codejstudio.lim.pojo.statement.Proposition
 * @see     com.codejstudio.lim.pojo.statement.Statement
 * @since   lim4j_v1.0.0
 */
public class Example17 {
	
	private static final String CLASS_NAME = Example17.class.getSimpleName();
	
	private static final String INPUT_FILE_PATH = "/samples/" + CLASS_NAME + ".xml";
	
	private static final String OUTPUT_FILE_PATH = "";//e.g. "d:/" + CLASS_NAME + ".xml"

	public static void main(String[] args) throws LIMException, FileNotFoundException {
		doXmlMarshal();
//		doXmlUnmarshal();
	}

	private static void doXmlMarshal() throws LIMException, FileNotFoundException {
		Argument a1 = new Argument("At standard atmospheric pressure, when the temperature drops to 0 ℃, water will gradually condense, so then water will go from liquid to solid.");
		Argument a2 = new Argument("Because water will gradually condense when it is at standard atmospheric pressure and its temperature drops to 0 ℃, water will go from liquid to solid.");

		Statement s1 = new Statement("At standard atmospheric pressure");
		Statement s2 = new Statement("the temperature drops to 0 ℃");
		Statement s3 = new Statement("water will gradually condense");
		Statement s4 = new Statement("water will go from liquid to solid");

		JudgedStatement js1 = new Proposition("at standard atmospheric pressure, when the temperature drops to 0 ℃, water will gradually condense");
		JudgedStatement js2 = new Proposition(s3);
		JudgedStatement js3 = new Proposition(s4);
		
		Condition cd1 = new Condition(s1);
		Condition cd2 = new Condition(s2);
		Condition cd3 = new Condition(cd1, true);
		Condition cd4 = new Condition(cd2, true);
		
		js1.addCondition(cd1, cd2);
		js3.addCondition(cd3, cd4);

		a1.addSubInformationElement(s1, s2, s3, s4);
		a1.addEvidence(js1);
		a1.addConclusion(js3);

		a2.addSubInformationElement(s3, s1, s2, s4);
		a2.addEvidence(js2);
		a2.addConclusion(js3);
		a2.addCondition(cd1, cd2);
		
		BaseRelation br1 = new EquivalenceRelation(a1, a2);

		Root root = new Root(br1);

		
		
		root.marshalToXml(true, System.out);
		
		//set OUTPUT_FILE_PATH first, before opening below comment code
//		root.marshalToXml(true, new BufferedOutputStream(new FileOutputStream(OUTPUT_FILE_PATH)));
	}

	private static void doXmlUnmarshal() throws LIMException {
		Root root = Root.unmarshalFromXml(Example17.class.getResource(INPUT_FILE_PATH));
		root.redecorate();
		root.marshalToXml(true, System.out);
	}

}
