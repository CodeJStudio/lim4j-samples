package com.codejstudio.lim.test;

import com.codejstudio.lim.common.util.CaseFormatUtil;
import com.codejstudio.lim.common.util.CaseFormatUtil.WordSeparator;

/**
 * CaseFormatUtilTest.class

 * @author <ul><li>Jeffrey Jiang</li></ul>
 * @see     com.codejstudio.lim.common.util.CaseFormatUtil
 * @since   lim4j_v1.0.0
 */
public class CaseFormatUtilTest {

	public static void main(String[] args) {
//		"lowerCamel", "UpperCamel" -> "lower_underscore", "lower-hyphen", "UPPER_UNDERSCORE", "UPPER-HYPHEN"
		System.out.println("lowerCamel， HYPHEN， true: " + CaseFormatUtil.camelToSeparated("lowerCamel", WordSeparator.HYPHEN, true));
		System.out.println("lowerCamel， UNDERSCORE， true: " + CaseFormatUtil.camelToSeparated("lowerCamel", WordSeparator.UNDERSCORE, true));
		System.out.println("lowerCamel， HYPHEN， false: " + CaseFormatUtil.camelToSeparated("lowerCamel", WordSeparator.HYPHEN, false));
		System.out.println("lowerCamel， UNDERSCORE， false: " + CaseFormatUtil.camelToSeparated("lowerCamel", WordSeparator.UNDERSCORE, false));
		System.out.println("UpperCamel， HYPHEN， true: " + CaseFormatUtil.camelToSeparated("UpperCamel", WordSeparator.HYPHEN, true));
		System.out.println("UpperCamel， UNDERSCORE， true: " + CaseFormatUtil.camelToSeparated("UpperCamel", WordSeparator.UNDERSCORE, true));
		System.out.println("UpperCamel， HYPHEN， false: " + CaseFormatUtil.camelToSeparated("UpperCamel", WordSeparator.HYPHEN, false));
		System.out.println("UpperCamel， UNDERSCORE， false: " + CaseFormatUtil.camelToSeparated("UpperCamel", WordSeparator.UNDERSCORE, false));
		
//		"lower_underscore", "lower-hyphen", "UPPER_UNDERSCORE", "UPPER-HYPHEN" -> "lowerCamel", "UpperCamel"
		System.out.println("lower-hyphen， HYPHEN， true: " + CaseFormatUtil.separatedToCamel("lower-hyphen", WordSeparator.HYPHEN, true));
		System.out.println("lower_underscore， UNDERSCORE， true: " + CaseFormatUtil.separatedToCamel("lower_underscore", WordSeparator.UNDERSCORE, true));
		System.out.println("lower-hyphen， HYPHEN， false: " + CaseFormatUtil.separatedToCamel("lower-hyphen", WordSeparator.HYPHEN, false));
		System.out.println("lower_underscore， UNDERSCORE， false: " + CaseFormatUtil.separatedToCamel("lower_underscore", WordSeparator.UNDERSCORE, false));
		System.out.println("UPPER-HYPHEN， HYPHEN， true: " + CaseFormatUtil.separatedToCamel("UPPER-HYPHEN", WordSeparator.HYPHEN, true));
		System.out.println("UPPER_UNDERSCORE， UNDERSCORE， true: " + CaseFormatUtil.separatedToCamel("UPPER_UNDERSCORE", WordSeparator.UNDERSCORE, true));
		System.out.println("UPPER-HYPHEN， HYPHEN， false: " + CaseFormatUtil.separatedToCamel("UPPER-HYPHEN", WordSeparator.HYPHEN, false));
		System.out.println("UPPER_UNDERSCORE， UNDERSCORE， false: " + CaseFormatUtil.separatedToCamel("UPPER_UNDERSCORE", WordSeparator.UNDERSCORE, false));
		
		System.out.println("UPPER_UNDERSCORE， HYPHEN， true: " + CaseFormatUtil.separatedToCamel("UPPER_UNDERSCORE", WordSeparator.HYPHEN, true));
		System.out.println("UPPER-HYPHEN， UNDERSCORE， true: " + CaseFormatUtil.separatedToCamel("UPPER-HYPHEN", WordSeparator.UNDERSCORE, true));
		System.out.println("UPPER_UNDERSCORE， HYPHEN， false: " + CaseFormatUtil.separatedToCamel("UPPER_UNDERSCORE", WordSeparator.HYPHEN, false));
		System.out.println("UPPER-HYPHEN， UNDERSCORE， false: " + CaseFormatUtil.separatedToCamel("UPPER-HYPHEN", WordSeparator.UNDERSCORE, false));
		
//		"lower_underscore", "lower-hyphen", "UPPER_UNDERSCORE", "UPPER-HYPHEN" -> "lowerCamel", "UpperCamel"
		System.out.println("lower-hyphen， HYPHEN， true: " + CaseFormatUtil.separatedToCamel0("lower-hyphen", WordSeparator.HYPHEN, true));
		System.out.println("lower_underscore， UNDERSCORE， true: " + CaseFormatUtil.separatedToCamel0("lower_underscore", WordSeparator.UNDERSCORE, true));
		System.out.println("lower-hyphen， HYPHEN， false: " + CaseFormatUtil.separatedToCamel0("lower-hyphen", WordSeparator.HYPHEN, false));
		System.out.println("lower_underscore， UNDERSCORE， false: " + CaseFormatUtil.separatedToCamel0("lower_underscore", WordSeparator.UNDERSCORE, false));
		System.out.println("UPPER-HYPHEN， HYPHEN， true: " + CaseFormatUtil.separatedToCamel0("UPPER-HYPHEN", WordSeparator.HYPHEN, true));
		System.out.println("UPPER_UNDERSCORE， UNDERSCORE， true: " + CaseFormatUtil.separatedToCamel0("UPPER_UNDERSCORE", WordSeparator.UNDERSCORE, true));
		System.out.println("UPPER-HYPHEN， HYPHEN， false: " + CaseFormatUtil.separatedToCamel0("UPPER-HYPHEN", WordSeparator.HYPHEN, false));
		System.out.println("UPPER_UNDERSCORE， UNDERSCORE， false: " + CaseFormatUtil.separatedToCamel0("UPPER_UNDERSCORE", WordSeparator.UNDERSCORE, false));
		
		System.out.println("UPPER_UNDERSCORE， HYPHEN， true: " + CaseFormatUtil.separatedToCamel0("UPPER_UNDERSCORE", WordSeparator.HYPHEN, true));
		System.out.println("UPPER-HYPHEN， UNDERSCORE， true: " + CaseFormatUtil.separatedToCamel0("UPPER-HYPHEN", WordSeparator.UNDERSCORE, true));
		System.out.println("UPPER_UNDERSCORE， HYPHEN， false: " + CaseFormatUtil.separatedToCamel0("UPPER_UNDERSCORE", WordSeparator.HYPHEN, false));
		System.out.println("UPPER-HYPHEN， UNDERSCORE， false: " + CaseFormatUtil.separatedToCamel0("UPPER-HYPHEN", WordSeparator.UNDERSCORE, false));
	}
	
}
