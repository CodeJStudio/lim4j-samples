# LIM4J Samples

Refer to: 

[Theory of Logical Information Model & Logical Information Network / 《逻辑信息模型与逻辑信息网络》](https://github.com/jhjiang/lim_lin)

[From Logical Information Model, to Logical Information Network, to the realization of Artificial General Intelligence (AGI)](https://www.reddit.com/user/JeffreyJiang/comments/upcloh/from_logical_information_model_to_logical/)

[《从逻辑信息模型，到逻辑信息网络，直至实现通用人工智能》](https://zhuanlan.zhihu.com/p/497443483)

---------

The code of "Hello World" is as follows:

```java
	public static void main(String[] args) throws Exception {
		Statement s1 = new Statement("Hello, world!");
		
		Concept c1 = new Concept("hello");
		Concept c2 = new Concept(",");
		Concept c3 = new Concept("world");
		Concept c4 = new Concept("!");
		Concept c5 = new Concept("H");
		Concept c6 = new Concept("h");
		Concept c7 = new Concept("e");
		Concept c8 = new Concept("l");
		Concept c9 = new Concept("o");
		Concept c10 = new Concept("w");
		Concept c11 = new Concept("r");
		Concept c12 = new Concept("d");
		
		s1.addConcept(c1, c2, c3, c4, c5);
		c1.addSubConcept(c6, c7, c8, c9);
		c3.addSubConcept(c10, c9, c11, c8, c12);
		
		Root root = new Root(s1);

		root.marshalToXml(true, System.out);
	}
```


Output：

```xml
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<lim-elements version="1.0">
    <statement id="0">
        <discription>Hello, world!</discription>
        <concept-group id="13" type="concept-group"/>
    </statement>
    <concept id="1">
        <discription>hello</discription>
        <sub-concept-group id="14" type="concept-group"/>
    </concept>
    <concept id="2">
        <discription>,</discription>
    </concept>
    <concept id="3">
        <discription>world</discription>
        <sub-concept-group id="15" type="concept-group"/>
    </concept>
    <concept id="4">
        <discription>!</discription>
    </concept>
    <concept id="5">
        <discription>H</discription>
    </concept>
    <concept id="6">
        <discription>h</discription>
    </concept>
    <concept id="7">
        <discription>e</discription>
    </concept>
    <concept id="8">
        <discription>l</discription>
    </concept>
    <concept id="9">
        <discription>o</discription>
    </concept>
    <concept id="10">
        <discription>w</discription>
    </concept>
    <concept id="11">
        <discription>r</discription>
    </concept>
    <concept id="12">
        <discription>d</discription>
    </concept>
    <concept id="13" type="concept-group">
        <itx-elements>
            <item key="group_5" id="5" type="concept"/>
            <item key="group_4" id="4" type="concept"/>
            <item key="group_1" id="1" type="concept"/>
            <item key="group_3" id="3" type="concept"/>
            <item key="group_2" id="2" type="concept"/>
        </itx-elements>
    </concept>
    <concept id="14" type="concept-group">
        <itx-elements>
            <item key="group_9" id="9" type="concept"/>
            <item key="group_8" id="8" type="concept"/>
            <item key="group_7" id="7" type="concept"/>
            <item key="group_6" id="6" type="concept"/>
        </itx-elements>
    </concept>
    <concept id="15" type="concept-group">
        <itx-elements>
            <item key="group_10" id="10" type="concept"/>
            <item key="group_9" id="9" type="concept"/>
            <item key="group_8" id="8" type="concept"/>
            <item key="group_11" id="11" type="concept"/>
            <item key="group_12" id="12" type="concept"/>
        </itx-elements>
    </concept>
</lim-elements>
```
