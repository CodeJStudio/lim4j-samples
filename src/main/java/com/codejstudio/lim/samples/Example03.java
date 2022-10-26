package com.codejstudio.lim.samples;

import java.io.FileNotFoundException;

import com.codejstudio.lim.common.exception.LIMException;
import com.codejstudio.lim.pojo.Root;
import com.codejstudio.lim.pojo.argument.Argument;
import com.codejstudio.lim.pojo.statement.JudgedStatement;
import com.codejstudio.lim.pojo.statement.Proposition;

/**
 * sample: Example03 
 * in "Theory of Logical Information Model & Logical Information Network"
 * from https://github.com/jhjiang/lim_lin
 * 
 * @author <ul><li>Jeffrey Jiang</li></ul>
 * @see     com.codejstudio.lim.pojo.Root
 * @see     com.codejstudio.lim.pojo.argument.Argument
 * @see     com.codejstudio.lim.pojo.statement.JudgedStatement
 * @see     com.codejstudio.lim.pojo.statement.Proposition
 * @since   lim4j_v1.0.0
 */
public class Example03 {
	
	private static final String CLASS_NAME = Example03.class.getSimpleName();
	
	private static final String INPUT_FILE_PATH = "/samples/" + CLASS_NAME + ".xml";
	
	private static final String OUTPUT_FILE_PATH = "";//e.g. "d:/" + CLASS_NAME + ".xml"

	public static void main(String[] args) throws LIMException, FileNotFoundException {
		doXmlMarshal();
//		doXmlUnmarshal();
	}

	private static void doXmlMarshal() throws LIMException, FileNotFoundException {
		Argument a1 = new Argument("① An outstanding advantage of nuclear over fossil fuel energy is how easy it is to deal with the waste it produces. "
				+ "② Burning fossil fuels produces 27,000 million tons of carbon dioxide yearly, enough to make, if solidified, a mountain nearly one mile high with a base twelve miles in circumference. "
				+ "③ The same quantity of energy produced from nuclear fission reactions would generate two million times less waste, and it would occupy a sixteen-meter cube. "
				+ "④ All of the high-level waste produced in a year from a nuclear power station would occupy a space about a cubic meter in size and would fit safely in a concrete pit.");

		JudgedStatement js1 = new Proposition("An outstanding advantage of nuclear over fossil fuel energy is how easy it is to deal with the waste it produces.");
		JudgedStatement js2 = new Proposition("Burning fossil fuels produces 27,000 million tons of carbon dioxide yearly, enough to make, if solidified, a mountain nearly one mile high with a base twelve miles in circumference.");
		JudgedStatement js3 = new Proposition("The same quantity of energy produced from nuclear fission reactions would generate two million times less waste, and it would occupy a sixteen-meter cube.");
		JudgedStatement js4 = new Proposition("All of the high-level waste produced in a year from a nuclear power station would occupy a space about a cubic meter in size and would fit safely in a concrete pit.");

		a1.addEvidence(js2, js3, js4);
		a1.addConclusion(js1);

		Root root = new Root(a1);

		
		
		root.marshalToXml(true, System.out);
		
		//set OUTPUT_FILE_PATH first, before opening below comment code
//		root.marshalToXml(true, new BufferedOutputStream(new FileOutputStream(OUTPUT_FILE_PATH)));
	}

	private static void doXmlUnmarshal() throws LIMException {
		Root root = Root.unmarshalFromXml(Example03.class.getResource(INPUT_FILE_PATH));
		root.redecorate();
		root.marshalToXml(true, System.out);
	}

}
