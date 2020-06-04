package com.example.programinglist;

import java.util.ArrayList;

public class ProgramingData {
    private static String[] programingNames = {
            "JAVA",
            "DART",
            "C++",
            "C#",
            "C",
            "PYTHON",
            "JAVASCRIPT",
            "HTML",
            "RUBY",
            "PHP"
    };

    private static String[] programingDetails = {
            "General-purpose programming language that is class-based, object-oriented, and designed to have as few implementation dependencies as possible.",
            "a client-optimized programming language for apps on multiple platforms. It is developed by Google and is used to build mobile, desktop, server, and web",
            "general-purpose programming language created by Bjarne Stroustrup as an extension of the C programming language, or \"C with Classes\".",
            "general-purpose, multi-paradigm programming language encompassing strong typing, lexically scoped, imperative, declarative, functional, generic",
            "general-purpose, procedural computer programming language supporting structured programming, lexical variable scope, and recursion, with a static",
            "is an interpreted, high-level, general-purpose programming language. Created by Guido van Rossum and first released in 1991",
            "is a programming language that conforms to the ECMAScript specification.",
            "is the standard markup language for documents designed to be displayed in a web browser.",
            "is an interpreted, high-level, general-purpose programming language. It was designed and developed in the mid-1990s by Yukihiro Matsumoto",
            "popular general-purpose scripting language that is especially suited to web development. It was originally created by Danish-Canadian"
    };

    private static int[] programingImages = {
            R.drawable.java,
            R.drawable.dart,
            R.drawable.c__,
            R.drawable.c_,
            R.drawable.c,
            R.drawable.python,
            R.drawable.javascript,
            R.drawable.html,
            R.drawable.ruby,
            R.drawable.php
    };

    static ArrayList<Programing> getListData() {
        ArrayList<Programing> list = new ArrayList<>();
        for (int position = 0; position < programingNames.length; position++) {
            Programing programing = new Programing();
            programing.setName(programingNames[position]);
            programing.setDetail(programingDetails[position]);
            programing.setImage(programingImages[position]);

            list.add(programing);
        }

        return list;
    }
}
