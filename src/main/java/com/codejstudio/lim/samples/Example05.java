package com.codejstudio.lim.samples;

import java.io.FileNotFoundException;

import com.codejstudio.lim.common.exception.LIMException;
import com.codejstudio.lim.pojo.Root;
import com.codejstudio.lim.pojo.concept.Concept;
import com.codejstudio.lim.pojo.statement.Definition;

/**
 * sample: Example05 
 * in "Theory of Logical Information Model & Logical Information Network"
 * from https://github.com/jhjiang/lim_lin
 * 
 * @author <ul><li>Jeffrey Jiang</li></ul>
 * @see     com.codejstudio.lim.pojo.Root
 * @see     com.codejstudio.lim.pojo.concept.Concept
 * @see     com.codejstudio.lim.pojo.statement.Definition
 * @since   lim4j_v1.0.0
 */
public class Example05 {
	
	private static final String CLASS_NAME = Example05.class.getSimpleName();
	
	private static final String INPUT_FILE_PATH = "/samples/" + CLASS_NAME + ".xml";
	
	private static final String OUTPUT_FILE_PATH = "";//e.g. "d:/" + CLASS_NAME + ".xml"

	public static void main(String[] args) throws LIMException, FileNotFoundException {
		doXmlMarshal();
//		doXmlUnmarshal();
	}

	private static void doXmlMarshal() throws LIMException, FileNotFoundException {
		Definition df1 = new Definition("Bird is a kind of warm-blooded vertebrate with feathers.");
		
		Concept c1 = new Concept("bird");
		Concept c2 = new Concept("is (be)");
		Concept c3 = new Concept("a kind of warm-blooded vertebrate with feathers");
		
		df1.setDefiniendum(c1);
		df1.setConnectiveOfDefinition(c2);
		df1.setDefiniens(c3);

		Root root = new Root(df1);

		
		
		root.marshalToXml(true, System.out);
		
		//set OUTPUT_FILE_PATH first, before opening below comment code
//		root.marshalToXml(true, new BufferedOutputStream(new FileOutputStream(OUTPUT_FILE_PATH)));
	}

	private static void doXmlUnmarshal() throws LIMException {
		Root root = Root.unmarshalFromXml(Example05.class.getResource(INPUT_FILE_PATH));
		root.redecorate();
		root.marshalToXml(true, System.out);
	}

}
