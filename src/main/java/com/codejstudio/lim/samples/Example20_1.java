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
 * sample: Example20_1 (Example9_1 in Figure 42) 
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
public class Example20_1 {
	
	private static final String CLASS_NAME = Example20_1.class.getSimpleName();
	
	private static final String INPUT_FILE_PATH = "/samples/" + CLASS_NAME + ".xml";
	
	private static final String OUTPUT_FILE_PATH = "";//e.g. "d:/" + CLASS_NAME + ".xml"

	public static void main(String[] args) throws LIMException {
		doXmlMarshal();
//		doXmlUnmarshal();
	}

	private static void doXmlMarshal() throws LIMException {
		Argument a1 = new Argument("All mammals have lungs. All whales are mammals. Therefore all whales have lungs.");
		a1.setValidity(new Validity(1));
		a1.addAttribute(new DefaultAttribute(new Proposition("This is a syllogism in the form of 'all M is P, all S is M, so all S is P'.")));

		JudgedStatement js1 = new Proposition("All mammals have lungs.");
		JudgedStatement js2 = new Proposition("All whales are mammals.");
		JudgedStatement js3 = new Proposition("All whales have lungs.");

		js1.setTruth(new Truth(1));
		js2.setTruth(new Truth(1));
		js3.setTruth(new Truth(1));

		JudgedStatementGroup jsg1 = new JudgedStatementGroup(js1, js2, js3);

		Concept c1 = new Concept("all");
		Concept c2 = new Concept("have lung");
		Concept c3 = new Concept("lung");
		Concept c4 = new Concept("whale");
		Concept c5 = new Concept("mammal");
		Concept c6 = null;

		js1.addConcept(c1, c2, c5);
		js1.addConcept(c6); //NullPointerException tolerance sample
		js2.addConcept(c1, c4, c5);
		js2.addConcept(); //NullPointerException tolerance sample
		js3.addConcept(c1, c2, c4);
		js3.addConcept(null, null); //NullPointerException tolerance sample
		c2.addSubConcept(c3);

		BaseRelation br1 = new EquivalenceRelation(a1, jsg1);

		Root root = new Root(a1, null, jsg1, br1); //NullPointerException tolerance sample

		
		
		root.marshalToXml(true, System.out);
		
		//set OUTPUT_FILE_PATH first, before opening below comment code
//		root.marshalToXml(true, new BufferedOutputStream(new FileOutputStream(OUTPUT_FILE_PATH)));
	}

	private static void doXmlUnmarshal() throws LIMException {
		Root root = Root.unmarshalFromXml(Example20_1.class.getResource(INPUT_FILE_PATH));
		root.redecorate();
		root.marshalToXml(true, System.out);
	}

}
