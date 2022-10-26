package com.codejstudio.lim.samples;

import java.io.FileNotFoundException;

import com.codejstudio.lim.common.exception.LIMException;
import com.codejstudio.lim.pojo.Root;
import com.codejstudio.lim.pojo.argument.Argument;
import com.codejstudio.lim.pojo.statement.JudgedStatement;
import com.codejstudio.lim.pojo.statement.Proposition;

/**
 * sample: Example02 
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
public class Example02 {
	
	private static final String CLASS_NAME = Example02.class.getSimpleName();
	
	private static final String INPUT_FILE_PATH = "/samples/" + CLASS_NAME + ".xml";
	
	private static final String OUTPUT_FILE_PATH = "";//e.g. "d:/" + CLASS_NAME + ".xml"

	public static void main(String[] args) throws LIMException, FileNotFoundException {
		doXmlMarshal();
//		doXmlUnmarshal();
	}

	private static void doXmlMarshal() throws LIMException, FileNotFoundException {
		Argument a1 = new Argument("① Because the greatest mitochondrial variations occurred in African people, "
				+ "② scientists concluded that they had the longest evolutionary history, "
				+ "③ indicating a probable African origin for modern humans.");
		
		Argument a2 = new Argument("① Because the greatest mitochondrial variations occurred in African people, "
				+ "② scientists concluded that they had the longest evolutionary history,");

		Argument a3 = new Argument("② (scientists concluded that )they had the longest evolutionary history, "
				+ "③ indicating a probable African origin for modern humans.");

		JudgedStatement js1 = new Proposition("the greatest mitochondrial variations occurred in African people,");
		JudgedStatement js2 = new Proposition("scientists concluded that they had the longest evolutionary history,");
		JudgedStatement js3 = new Proposition("(there is )a probable African origin for modern humans.");

		a2.addEvidence(js1);
		a2.addConclusion(js2);
		a3.addEvidence(js2);
		a3.addConclusion(js3);
		a1.addSubArgument(a2, a3);

		Root root = new Root(a1);

		
		
		root.marshalToXml(true, System.out);
		
		//set OUTPUT_FILE_PATH first, before opening below comment code
//		root.marshalToXml(true, new BufferedOutputStream(new FileOutputStream(OUTPUT_FILE_PATH)));
	}

	private static void doXmlUnmarshal() throws LIMException {
		Root root = Root.unmarshalFromXml(Example02.class.getResource(INPUT_FILE_PATH));
		root.redecorate();
		root.marshalToXml(true, System.out);
	}

}
