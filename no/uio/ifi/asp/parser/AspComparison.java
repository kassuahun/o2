package no.uio.ifi.asp.parser;

import no.uio.ifi.asp.main.Main;
import no.uio.ifi.asp.runtime.RuntimeReturnValue;
import no.uio.ifi.asp.runtime.RuntimeScope;
import no.uio.ifi.asp.runtime.RuntimeValue;
import no.uio.ifi.asp.scanner.Scanner;

import java.util.ArrayList;

public class AspComparison extends AspSyntax{

    ArrayList<AspTerm> terms = new ArrayList<AspTerm>();
    ArrayList<AspCompOpr> compOprs = new ArrayList<AspCompOpr>();

    AspComparison(int n) {
        super(n);
    }

    public static AspComparison parse(Scanner s) {
        Main.log.enterParser("comparison");

        AspComparison comp = new AspComparison(s.curLineNum());
        comp.terms.add(AspTerm.parse(s));

        while(true){
            if(!s.isCompOpr()) break;
            comp.compOprs.add(AspCompOpr.parse(s));
            comp.terms.add(AspTerm.parse(s));
        }

        Main.log.leaveParser("comparison");
        return comp;
    }

    @Override
    protected void prettyPrint() {
        terms.get(0).prettyPrint();
        for (int i = 1; i <terms.size(); i++) {
            compOprs.get(i-1).prettyPrint();
            terms.get(i).prettyPrint();
        }
    }

    @Override
    RuntimeValue eval(RuntimeScope curScope) throws RuntimeReturnValue {
        return null;
    }
}
