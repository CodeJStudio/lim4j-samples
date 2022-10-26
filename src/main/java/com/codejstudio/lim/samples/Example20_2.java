package com.codejstudio.lim.samples;

import com.codejstudio.lim.common.exception.LIMException;
import com.codejstudio.lim.pojo.Root;
import com.codejstudio.lim.pojo.argument.Argument;
import com.codejstudio.lim.pojo.argument.Validity;
import com.codejstudio.lim.pojo.attribute.DefaultAttribute;
import com.codejstudio.lim.pojo.concept.Concept;
import com.codejstudio.lim.pojo.relation.BaseRelation;
import com.codejstudio.lim.pojo.relation.EquivalenceRelation;
import com.codejstudio.lim.pojo.statement.JudgedStatement;
import com.codejstudio.lim.pojo.statement.JudgedStatementGroup;
import com.codejstudio.lim.pojo.statement.Proposition;
import com.codejstudio.lim.pojo.statement.Truth;

/**
 * sample: Example20_2 (Example9_2 in Figure 43) 
 * in "Theory of Logical Information Model & Logical Information Network"
 * from https://github.com/jhjiang/lim_lin
 * 
 * @author <ul><li>Jeffrey Jiang</li></ul>
 * @see     com.codejstudio.lim.pojo.Root
 * @see     com.codejstudio.lim.pojo.argument.Argument
 * @see     com.codejstudio.lim.pojo.argument.Validity
 * @see     com.codejstudio.lim.pojo.attribute.DefaultAttribute
 * @see     com.codejstudio.lim.pojo.concept.Concept
 * @see     com.codejstudio.lim.pojo.relation.BaseRelation
 * @see     com.codejstudio.lim.pojo.relation.EquivalenceRelation
 * @see     com.codejstudio.lim.pojo.statement.JudgedStatement
 * @see     com.codejstudio.lim.pojo.statement.JudgedStatementGroup
 * @see     com.codejstudio.lim.pojo.statement.Proposition
 * @see     com.codejstudio.lim.pojo.statement.Truth
 * @since   lim4j_v1.0.0
 */
public class Example20_2 {
	
	private static final String CLASS_NAME = Example20_2.class.getSimpleName();
	
	private static final String INPUT_FILE_PATH = "/samples/" + CLASS_NAME + ".xml";
	
	private static final String OUTPUT_FILE_PATH = "";//e.g. "d:/" + CLASS_NAME + ".xml"

	public static void main(String[] args) throws LIMException {
		doXmlMarshal();
//		doXmlUnmarshal();
	}

	private static void doXmlMarshal() throws LIMException {
		Argument a1 = new Argument("All soldiers who want to be generals are not cowards. Some soldiers are cowards. Therefore some soldiers don't want to be generals.");
		a1.setValidity(new Validity(1));
		a1.addAttribute(new DefaultAttribute(new Proposition("This is a syllogism in the form of 'no P is M (or all P is not M), some S is M, so some S is not P'.")));

		JudgedStatement js1 = new Proposition("All soldiers who want to be generals are not cowards.");
		JudgedStatement js2 = new Proposition("Some soldiers are cowards.");
		JudgedStatement js3 = new Proposition("Some soldiers don't want to be generals.");
		JudgedStatement js4 = new Proposition("Some soldiers are not the soldiers who want to be generals.");

		js1.setTruth(new Truth(1));
		js2.setTruth(new Truth(1));
		js3.setTruth(new Truth(1));

		JudgedStatementGroup jsg1 = new JudgedStatementGroup(js1, js2, js3);

		Concept c1 = new Concept("soldier");
		Concept c2 = new Concept("all");
		Concept c3 = new Concept("no / not");
		Concept c4 = new Concept("want to be general");
		Concept c5 = new Concept("general");
		Concept c6 = new Concept("some");
		Concept c7 = new Concept("coward");

		js1.addConcept(c2, c1, c4, c3, c7);
		js2.addConcept(c6, c1, c7);
		js3.addConcept(c6, c1, c3, c4);
		c4.addSubConcept(c5);

		BaseRelation br1 = new EquivalenceRelation(js3, js4);
		BaseRelation br2 = new EquivalenceRelation(a1, jsg1);

		Root root = new Root(a1, jsg1, br1, br2);

		
		
		root.marshalToXml(true, System.out);
		
		//set OUTPUT_FILE_PATH first, before opening below comment code
//		root.marshalToXml(true, new BufferedOutputStream(new FileOutputStream(OUTPUT_FILE_PATH)));
	}

	private static void doXmlUnmarshal() throws LIMException {
		Root root = Root.unmarshalFromXml(Example20_2.class.getResource(INPUT_FILE_PATH));
		root.redecorate();
		root.marshalToXml(true, System.out);
	}

}
