package no.uio.ifi.asp.parser;

import java.util.ArrayList;

import no.uio.ifi.asp.main.*;
import no.uio.ifi.asp.runtime.*;
import no.uio.ifi.asp.scanner.*;
import static no.uio.ifi.asp.scanner.TokenKind.*;

public class AspProgram extends AspSyntax {
    //-- Must be changed in part 2:
    ArrayList<AspStmt> stmts = new ArrayList<>();

    AspProgram(int n) {
	super(n);
    }


    public static AspProgram parse(Scanner s) {
	Main.log.enterParser("program");

	AspProgram prog = new AspProgram(s.curLineNum());
	while (s.curToken().kind != eofToken) {
	    //-- Must be changed in part 2:

         prog.stmts.add(AspStmt.parse(s));
         //s.readNextToken();

	}

	Main.log.leaveParser("program");
	return prog;
    }


    @Override
    public void prettyPrint() {
	//-- Must be changed in part 2:
        for (AspStmt st: stmts) {
            st.prettyPrint();
        }
    }


    @Override
    public RuntimeValue eval(RuntimeScope curScope) throws RuntimeReturnValue {
	//-- Must be changed in part 4:
	return null;
    }
}
