/*
 * Copyright 2006-2011 Sam Adams <sea36 at users.sourceforge.net>
 *
 * This file is part of JNI-InChI.
 *
 * JNI-InChI is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published
 * by the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * JNI-InChI is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with JNI-InChI.  If not, see <http://www.gnu.org/licenses/>.
 */
package net.sf.jniinchi;

import junit.framework.TestCase;


import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

public class TestJniInchiBond extends TestCase {

    private static JniInchiAtom atO = new JniInchiAtom(0, 0, 0, "O");
    private static JniInchiAtom atT = new JniInchiAtom(1.21, 0, 0, "O");

    protected static JniInchiBond getTestBond() {
        return new JniInchiBond(atO, atT, INCHI_BOND_TYPE.DOUBLE);
    }

    // tm-2
    // Expand branch coverage for switch statement in INCHI_BOND_TYPE.getValue (NONE case)
    @Test
    public void testINCHI_BOND_TYPEgetValueNONE() throws Exception {
        int input = 0;
        INCHI_BOND_TYPE output = INCHI_BOND_TYPE.getValue(input);
        assertEquals(INCHI_BOND_TYPE.NONE, output);
    }
    
 	// tm-3
    // Expand branch coverage for switch statement in INCHI_BOND_TYPE.getValue (ALTERN case)
    @Test
    public void testINCHI_BOND_TYPEgetValueALTERN() throws Exception {
        int input = 4;
        INCHI_BOND_TYPE output = INCHI_BOND_TYPE.getValue(input);
        assertEquals(INCHI_BOND_TYPE.ALTERN, output);
    }
    
    // tm-4
    // Expand branch coverage for switch statement in INCHI_BOND_TYPE.getValue (null case)
    @Test
    public void testINCHI_BOND_TYPEgetValueNull() throws Exception {
        int input = 5;
        INCHI_BOND_TYPE output = INCHI_BOND_TYPE.getValue(input);
        assertEquals(null, output);
    }
    
    // tm-5
    // Expand branch coverage for switch statement in INCHI_RADICAL.getValue (SINGLET case)
    @Test
    public void testINCHI_RADICALgetValueSINGLET() throws Exception {
        int input = 1;
        INCHI_RADICAL output = INCHI_RADICAL.getValue(input);
        assertEquals(INCHI_RADICAL.SINGLET, output);
    }
    
    // tm-6
    // Expand branch coverage for switch statement in INCHI_RADICAL.getValue (DOUBLET case)
    @Test
    public void testINCHI_RADICALgetValueDOUBLET() throws Exception {
        int input = 2;
        INCHI_RADICAL output = INCHI_RADICAL.getValue(input);
        assertEquals(INCHI_RADICAL.DOUBLET, output);
    }
    
    // tm-7
    // Expand branch coverage for switch statement in INCHI_RADICAL.getValue (TRIPLET case)
    @Test
    public void testINCHI_RADICALgetValueTRIPLET() throws Exception {
        int input = 3;
        INCHI_RADICAL output = INCHI_RADICAL.getValue(input);
        assertEquals(INCHI_RADICAL.TRIPLET, output);
    }
    
    // tm-8
    // Expand branch coverage for switch statement in INCHI_RADICAL.getValue (null case)
    @Test
    public void testINCHI_RADICALgetValueNull() throws Exception {
        int input = 4;
        INCHI_RADICAL output = INCHI_RADICAL.getValue(input);
        assertEquals(null, output);
    }
    
    // tm-9
    // Coverage for untested null case in INCHI_OPTION.valueOfIgnoreCase
    @Test
    public void testINCHI_OPTIONLvalueOfIgnoreCase() throws Exception {
        String input = "DeRP";
        INCHI_OPTION output = INCHI_OPTION.valueOfIgnoreCase(input);
        assertEquals(null, output);
    }
    
    // tm-10
    // Expand branch coverage for switch statement in INCHI_PARITY.getValue (NONE case)
    @Test
    public void testINCHI_PARITYgetValueNONE() throws Exception {
        int input = 0;
        INCHI_PARITY output = INCHI_PARITY.getValue(input);
        assertEquals(INCHI_PARITY.NONE, output);
    }
    
    // tm-11
    // Expand branch coverage for switch statement in INCHI_PARITY.getValue (UNKNOWN case)
    @Test
    public void testINCHI_PARITYgetValueUNKNOWN() throws Exception {
        int input = 3;
        INCHI_PARITY output = INCHI_PARITY.getValue(input);
        assertEquals(INCHI_PARITY.UNKNOWN, output);
    }
    
    // tm-12
    // Expand branch coverage for switch statement in INCHI_PARITY.getValue (UNDEFINED case)
    @Test
    public void testINCHI_PARITYgetValueUNDEFINED() throws Exception {
        int input = 4;
        INCHI_PARITY output = INCHI_PARITY.getValue(input);
        assertEquals(INCHI_PARITY.UNDEFINED, output);
    }
    
    // tm-13
    // Expand branch coverage for switch statement in INCHI_PARITY.getValue (null case)
    @Test
    public void testINCHI_PARITYgetValueNull() throws Exception {
        int input = 5;
        INCHI_PARITY output = INCHI_PARITY.getValue(input);
        assertEquals(null, output);
    }
    
    // tm-15
    // Expand branch coverage for switch statement in INCHI_KEY_STATUS.getValue (null case)
    @Test
    public void testINCHI_KEY_STATUSgetValueNull() throws Exception {
        int input = 4;
        INCHI_KEY_STATUS output = INCHI_KEY_STATUS.getValue(input);
        assertEquals(null, output);
    }
    
    // tm-16
    // Test INCHI_KEY_STATUS object's "getter"
    @Test
    public void testINCHI_KEY_STATUSgetIndx() throws Exception {
        INCHI_KEY_STATUS test = INCHI_KEY_STATUS.VALID_STANDARD;
        int output = test.getIndx();
        assertEquals(0, output);
    }
    
    // tm-17
    // Test INCHI_KEY object's "getter"
    @Test
    public void testINCHI_KEYgetIndx() throws Exception {
        INCHI_KEY test = INCHI_KEY.OK;
        int output = test.getIndx();
        assertEquals(0, output);
    }
    
    // tm-18
    // Expand branch coverage for switch statement in INCHI_KEY.getValue (UNKNOWN_ERROR case)
    @Test
    public void testINCHI_KEYgetValueUNKNOWN_ERROR() throws Exception {
        int input = 1;
        INCHI_KEY output = INCHI_KEY.getValue(input);
        assertEquals(INCHI_KEY.UNKNOWN_ERROR, output);
    }
    
    // tm-19
    // Expand branch coverage for switch statement in INCHI_KEY.getValue (EMPTY_INPUT case)
    @Test
    public void testINCHI_KEYgetValueEMPTY_INPUT() throws Exception {
        int input = 2;
        INCHI_KEY output = INCHI_KEY.getValue(input);
        assertEquals(INCHI_KEY.EMPTY_INPUT, output);
    }
    
    // tm-20
    // Expand branch coverage for switch statement in INCHI_KEY.getValue (NOT_ENOUGH_MEMORY case)
    @Test
    public void testINCHI_KEYgetValueNOT_ENOUGH_MEMORY() throws Exception {
        int input = 4;
        INCHI_KEY output = INCHI_KEY.getValue(input);
        assertEquals(INCHI_KEY.NOT_ENOUGH_MEMORY, output);
    }
    
    // tm-21
    // Expand branch coverage for switch statement in INCHI_KEY.getValue (INVALID_STD_INCHI case)
    @Test
    public void testINCHI_KEYgetValueINVALID_STD_INCHI() throws Exception {
        int input = 21;
        INCHI_KEY output = INCHI_KEY.getValue(input);
        assertEquals(INCHI_KEY.INVALID_STD_INCHI, output);
    }
    
    // tm-22
    // Expand branch coverage for switch statement in INCHI_KEY.getValue (null case)
    @Test
    public void testINCHI_KEYgetValueNull() throws Exception {
        int input = 5;
        INCHI_KEY output = INCHI_KEY.getValue(input);
        assertEquals(null, output);
    }
    
    // tm-23
    // Test INCHI_STATUS object's "getter"
    @Test
    public void testINCHI_STATUSgetIndx() throws Exception {
    	INCHI_STATUS test = INCHI_STATUS.FAIL_I2I;
        int output = test.getIndx();
        assertEquals(4, output);
    }
    
    // tm-24
    // Expand branch coverage for switch statement in INCHI_STATUS.getValue (INVALID_LAYOUT case)
    @Test
    public void testINCHI_STATUSgetValueINVALID_LAYOUT() throws Exception {
        int input = 3;
        INCHI_STATUS output = INCHI_STATUS.getValue(input);
        assertEquals(INCHI_STATUS.INVALID_LAYOUT, output);
    }
    
    // tm-25
    // Expand branch coverage for switch statement in INCHI_STATUS.getValue (null case)
    @Test
    public void testINCHI_STATUSgetValueNull() throws Exception {
        int input = 5;
        INCHI_STATUS output = INCHI_STATUS.getValue(input);
        assertEquals(null, output);
    }
    
    // tm-26
    // Test exception for null retStatus option in JniInchiOutputKey constructor
    @Test
    public void testJniInchiOutputKeyNullRetStatusException() throws JniInchiException {
        try
        {
        	JniInchiOutputKey test = new JniInchiOutputKey(null, "eeeee");
        	Assert.fail();
        }
        catch(NullPointerException nullret)
        {
        	String message = "Null return status";
        	assertEquals(message, nullret.getMessage());
        }
    }
    
    // tm-27
    // Test exception for null retStatus option in JniInchiOutputKey constructor
    @Test
    public void testJniInchiOutputKeyNullKeyException() throws JniInchiException {
        try
        {
        	JniInchiOutputKey test = new JniInchiOutputKey(INCHI_KEY.OK, null);
        	Assert.fail();
        }
        catch(NullPointerException nullret)
        {
        	String message = "Null InChIkey";
        	assertEquals(message, nullret.getMessage());
        }
    }
    
    // tm-28
    // Expand branch coverage for switch statement in INCHI_STEREOTYPE.getValue (NONE case)
    @Test
    public void testINCHI_STEREOTYPEgetValueNONE() throws Exception {
        int input = 0;
        INCHI_STEREOTYPE output = INCHI_STEREOTYPE.getValue(input);
        assertEquals(INCHI_STEREOTYPE.NONE, output);
    }
    
    // tm-29
    // Expand branch coverage for switch statement in INCHI_STEREOTYPE.getValue (ALLENE case)
    @Test
    public void testINCHI_STEREOTYPEgetValueALLENE() throws Exception {
        int input = 3;
        INCHI_STEREOTYPE output = INCHI_STEREOTYPE.getValue(input);
        assertEquals(INCHI_STEREOTYPE.ALLENE, output);
    }
    
    // tm-30
    // Expand branch coverage for switch statement in INCHI_STEREOTYPE.getValue (null case)
    @Test
    public void testINCHI_STEREOTYPEgetValueNull() throws Exception {
        int input = 4;
        INCHI_STEREOTYPE output = INCHI_STEREOTYPE.getValue(input);
        assertEquals(null, output);
    }
    
    // tm-31
    // Test INCHI_RET object's "getter"
    @Test
    public void testINCHI_RETgetIndx() throws Exception {
    	INCHI_RET test = INCHI_RET.WARNING;
        int output = test.getIndx();
        assertEquals(1, output);
    }
    
    // tm-32
    // Expand branch coverage for switch statement in INCHI_RET.getValue (SKIP case)
    @Test
    public void testINCHI_RETgetValueSKIP() throws Exception {
        int input = -2;
        INCHI_RET output = INCHI_RET.getValue(input);
        assertEquals(INCHI_RET.SKIP, output);
    }
    
    // tm-33
    // Expand branch coverage for switch statement in INCHI_RET.getValue (ERROR case)
    @Test
    public void testINCHI_RETgetValueERROR() throws Exception {
        int input = 2;
        INCHI_RET output = INCHI_RET.getValue(input);
        assertEquals(INCHI_RET.ERROR, output);
    }
    
    // tm-34
    // Expand branch coverage for switch statement in INCHI_RET.getValue (FATAL case)
    @Test
    public void testINCHI_RETgetValueFATAL() throws Exception {
        int input = 3;
        INCHI_RET output = INCHI_RET.getValue(input);
        assertEquals(INCHI_RET.FATAL, output);
    }
    
    // tm-35
    // Expand branch coverage for switch statement in INCHI_RET.getValue (UNKNOWN case)
    @Test
    public void testINCHI_RETgetValueUNKNOWN() throws Exception {
        int input = 4;
        INCHI_RET output = INCHI_RET.getValue(input);
        assertEquals(INCHI_RET.UNKNOWN, output);
    }
    
    // tm-36
    // Expand branch coverage for switch statement in INCHI_RET.getValue (BUSY case)
    @Test
    public void testINCHI_RETgetValueBUSY() throws Exception {
        int input = 5;
        INCHI_RET output = INCHI_RET.getValue(input);
        assertEquals(INCHI_RET.BUSY, output);
    }
    
    // tm-37
    // Expand branch coverage for switch statement in INCHI_RET.getValue (null case)
    @Test
    public void testINCHI_RETgetValueNull() throws Exception {
        int input = 6;
        INCHI_RET output = INCHI_RET.getValue(input);
        assertEquals(null, output);
    }
    
    // tm-38
    // Expand branch coverage for switch statement in INCHI_BOND_STEREO.getValue (SINGLE_1UP case)
    @Test
    public void testINCHI_BOND_STEREOgetValueSINGLE_1UP() throws Exception {
        int input = 1;
        INCHI_BOND_STEREO output = INCHI_BOND_STEREO.getValue(input);
        assertEquals(INCHI_BOND_STEREO.SINGLE_1UP, output);
    }
    
    // tm-39
    // Expand branch coverage for switch statement in INCHI_BOND_STEREO.getValue (SINGLE_1EITHER case)
    @Test
    public void testINCHI_BOND_STEREOgetValueSINGLE_1EITHER() throws Exception {
        int input = 4;
        INCHI_BOND_STEREO output = INCHI_BOND_STEREO.getValue(input);
        assertEquals(INCHI_BOND_STEREO.SINGLE_1EITHER, output);
    }
    
    // tm-40
    // Expand branch coverage for switch statement in INCHI_BOND_STEREO.getValue (SINGLE_1DOWN case)
    @Test
    public void testINCHI_BOND_STEREOgetValueSINGLE_1DOWN() throws Exception {
        int input = 6;
        INCHI_BOND_STEREO output = INCHI_BOND_STEREO.getValue(input);
        assertEquals(INCHI_BOND_STEREO.SINGLE_1DOWN, output);
    }
    
    // tm-41
    // Expand branch coverage for switch statement in INCHI_BOND_STEREO.getValue (DOUBLE_EITHER case)
    @Test
    public void testINCHI_BOND_STEREOgetValueDOUBLE_EITHER() throws Exception {
        int input = 3;
        INCHI_BOND_STEREO output = INCHI_BOND_STEREO.getValue(input);
        assertEquals(INCHI_BOND_STEREO.DOUBLE_EITHER, output);
    }
    
    // tm-42
    // Expand branch coverage for switch statement in INCHI_BOND_STEREO.getValue (SINGLE_2UP case)
    @Test
    public void testINCHI_BOND_STEREOgetValueSINGLE_2UP() throws Exception {
        int input = -1;
        INCHI_BOND_STEREO output = INCHI_BOND_STEREO.getValue(input);
        assertEquals(INCHI_BOND_STEREO.SINGLE_2UP, output);
    }
    
    // tm-43
    // Expand branch coverage for switch statement in INCHI_BOND_STEREO.getValue (SINGLE_2EITHER case)
    @Test
    public void testINCHI_BOND_STEREOgetValueSINGLE_2EITHER() throws Exception {
        int input = -4;
        INCHI_BOND_STEREO output = INCHI_BOND_STEREO.getValue(input);
        assertEquals(INCHI_BOND_STEREO.SINGLE_2EITHER, output);
    }
    
    // tm-44
    // Expand branch coverage for switch statement in INCHI_BOND_STEREO.getValue (null case)
    @Test
    public void testINCHI_BOND_STEREOgetValueNull() throws Exception {
        int input = 7;
        INCHI_BOND_STEREO output = INCHI_BOND_STEREO.getValue(input);
        assertEquals(null, output);
    }
    
    // tm-45
    // Verify that Main's getTestMolecule method indeed returns a valid JniInchiStructure
    @Test
    public void testgetTestMoleculeworks() throws Exception {
        Assert.assertTrue(Main.getTestMolecule() instanceof JniInchiStructure);
    }
    
    // tm-46
    // Coverage for Main.runChecks, which verifies using the debugging information printed in console error
    @Test
    public void testMainrunChecks() throws Exception {
    	ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    	//redirect the system error to outContent
    	System.setErr(new PrintStream(outContent));

    	Main.runChecks();
    	
    	assertEquals("Loading native code\n\n\nNative code version: " + JniInchiWrapper.LibInchiGetVersion() +
    			"\n\nRunning checks\n\nGenerating InChI from structure\n - OKAY\nGenerating structure from InChI\n - OKAY\nConverting structure back to InChI\n - OKAY\n\nChecks done.\n\n", outContent.toString());
    }
    
    // tm-47
    // Special branch coverage for lone "-debug" option passed to Main.main (again verified with printed debugging information)
    @Test
    public void testMainmaindebug() throws Exception {
    	ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    	//redirect the system error to outContent
    	System.setErr(new PrintStream(outContent));
    	
    	String[] args = {"-debug"};
    	Main.main(args);
    	
    	assertEquals("\n** JniInchi debugger **\n\nLoading native code\n\n\nNative code version: " + JniInchiWrapper.LibInchiGetVersion() +
    			"\n\nRunning checks\n\nGenerating InChI from structure\n - OKAY\nGenerating structure from InChI\n - OKAY\nConverting structure back to InChI\n - OKAY\n\nChecks done.\n\n", outContent.toString());
    }
    
    // tm-48
    // Test JniInchiInput object's constructor for List
    @Test
    public void testJniInchiInputconstructorList() throws Exception {
    	List<INCHI_OPTION> options = new ArrayList<INCHI_OPTION>();
    	options.add(INCHI_OPTION.SUCF);
    	options.add(INCHI_OPTION.AuxNone);
    	
    	JniInchiInput test = new JniInchiInput(options);
        assertEquals(test.getOptions(), JniInchiWrapper.checkOptions(options));
    }
    
    // tm-49
    // Test JniInchiInput object's String constructor for null input
    @Test
    public void testJniInchiInputconstructornull() throws Exception {
    	String dud = null;
    	JniInchiInput test = new JniInchiInput(dud);
        assertEquals(test.getOptions(), "");
    }
    
    // tm-50
    // Test JniInchiInput object's constructor for struct and string combo
    @Test
    public void testJniInchiInputconstructorStructString() throws Exception {
    	JniInchiStructure molecule = new JniInchiStructure();
    	JniInchiAtom a1 = molecule.addAtom(new JniInchiAtom(264.0, 968.0, 0.0, "C"));
    	JniInchiAtom a2 = molecule.addAtom(new JniInchiAtom(295.0, 985.0, 0.0, "C"));
    	JniInchiBond bond = molecule.addBond(new JniInchiBond(a1, a2, INCHI_BOND_TYPE.SINGLE));
    	
    	String option = "SUCF";
    	
    	JniInchiInput test = new JniInchiInput(molecule, option);
        assertEquals(test.getOptions(), JniInchiWrapper.checkOptions(option));
        assertEquals(test.getNumAtoms(), 2);
        assertEquals(test.getBond(0), bond);
        assertEquals(test.getNumStereo0D(), 0);
    }
    
    // tm-51
    // Test JniInchiStructure objects index getter for stereo
    @Test
    public void testJniInchiStructuregetStereoIndex() throws Exception {
    	JniInchiStructure molecule = new JniInchiStructure();
    	JniInchiAtom a1 = molecule.addAtom(new JniInchiAtom(264.0, 968.0, 0.0, "C"));
    	JniInchiStereo0D stereo = new JniInchiStereo0D(new NewJniInchiStereo0DAtoms(a1, a1, a1, a1, a1), INCHI_STEREOTYPE.DOUBLEBOND, INCHI_PARITY.ODD);
    	
    	molecule.addStereo0D(stereo);
        assertEquals(molecule.getStereo0DIndex(stereo), 0);
    }
    
    // tm-52
    // Test debug feature of JniInchiAtom object
    @Test
    public void testJniInchiAtomdebug() throws Exception {
    	ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    	//redirect the system out to outContent
    	System.setOut(new PrintStream(outContent));
    	
    	JniInchiAtom hydrogen = new JniInchiAtom("H");
    	hydrogen.debug();
    	
    	assertEquals("InChI Atom: H [0.0,0.0,0.0] Charge:0 // Iso Mass:0 // Implicit H:-1 P:0 D:0 T:0 // Radical: NONE\n", outContent.toString());
    }
    
    // tm-53
    // Test debug feature of JniInchiStereo0D object
    @Test
    public void testJniInchiStereodebug() throws Exception {
    	ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    	//redirect the system out to outContent
    	System.setOut(new PrintStream(outContent));
    	
    	JniInchiAtom h = new JniInchiAtom("H");
    	JniInchiStereo0D stereo = new JniInchiStereo0D(new NewJniInchiStereo0DAtoms(h, h, h, h, h), INCHI_STEREOTYPE.DOUBLEBOND, INCHI_PARITY.ODD);
    	stereo.debug();
    	
    	assertEquals("InChI Stereo0D: H [H,H,H,H] Type::DOUBLEBOND // Parity:ODD\n", outContent.toString());
    }
    
    // tm-54
    // Test exception for invalid INCHI_OPTION passed to JniInchiWrapper.checkOptions
    @Test
    public void testJniInchiWrapperInvalidInChIOptionException() throws JniInchiException {
        try
        {
        	List options = new ArrayList();
        	options.add(INCHI_OPTION.SUCF);
        	options.add("derp");
        	JniInchiWrapper.checkOptions(options);
        	Assert.fail();
        }
        catch(JniInchiException badoption)
        {
        	String message = "Unrecognised InChI option";
        	assertEquals(message, badoption.getMessage());
        }
    }
    
    // tm-55
    @Test
    public void testJniInchiStereo0DNO_ATOM() throws Exception {
    	assertEquals(JniInchiStereo0D.getNO_ATOM(), -1);
    }
    
    /*
    // tm--
    // Test exception for null retStatus option in JniInchiOutputKey constructor
    @Test
    public void testJniInchiWrapperderp() throws JniInchiException {
        try
        {
        	String key = "AAAAAAAAAAAAAA-AAAAAAAAAA-N";
        	Assert.assertEquals(JniInchiWrapper.checkInchiKey(key), INCHI_KEY_STATUS.INVALID_LENGTH);
        	// Assert.fail();
        }
        catch(JniInchiException badkey)
        {
        	String message = "Unknown return status: ";
        	assertEquals(message, badkey.getMessage());
        }
    }
    */
    
    // tm-55
    // Test exception for null AuxInfo string passed to JniInchiWrapper.getInputFromAuxInfo
    @Test
    public void testJniInchiWrapperNullAuxInfoException() throws JniInchiException {
        try
        {
        	String info = null;
        	JniInchiWrapper.getInputFromAuxInfo(info);
        	Assert.fail();
        }
        catch(IllegalArgumentException nullinfo)
        {
        	String message = "Null AuxInfo";
        	assertEquals(message, nullinfo.getMessage());
        }
    }
    
    // tm-56
    // Test status setter of JniInchiOutputStructure
    @Test
    public void testJniInchiOutputStructureStatusSet() throws Exception {
    	JniInchiOutputStructure status = new JniInchiOutputStructure(INCHI_RET.OKAY);
    	status.setRetStatus(INCHI_RET.ERROR);
    	
    	assertEquals(status.getReturnStatus(), INCHI_RET.ERROR);
    }
    
    // tm-57
    // Test debug feature of JniInchiBond object
    @Test
    public void testJniInchiBonddebug() throws Exception {
    	ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    	//redirect the system out to outContent
    	System.setOut(new PrintStream(outContent));
    	
    	JniInchiAtom h = new JniInchiAtom("H");
    	JniInchiBond bond = new JniInchiBond(h, h, INCHI_BOND_TYPE.DOUBLE, INCHI_BOND_STEREO.SINGLE_1UP);
    	bond.debug();
    	
    	assertEquals("InChI Bond: H-H // Type: DOUBLE // Stereo: SINGLE_1UP\n", outContent.toString());
    }
    
    // tm-58
    // Test getErrorMessage functionality of JniInchiInputData object
    @Test
    public void testJniInchiInputDatagetError() throws Exception {
    	JniInchiInput input = new JniInchiInput();
    	JniInchiInputData data = new JniInchiInputData(0, input, 1, "Explosion");
    	  	
    	assertEquals(data.getErrorMessage(), "Explosion");
    }
    
    // tm-59
    // Test JniInchiInputInchi object's constructor for String and List combo
    @Test
    public void testJniInchiInputInchiconstructorStringList() throws Exception {
    	List<INCHI_OPTION> options = new ArrayList<INCHI_OPTION>();
    	options.add(INCHI_OPTION.SUCF);
    	options.add(INCHI_OPTION.AuxNone);
    	
    	String inchi = "inchi string";
    	
    	JniInchiInputInchi test = new JniInchiInputInchi(inchi, options);
    	assertEquals(test.getInchi(), inchi);
        assertEquals(test.getOptions(), JniInchiWrapper.checkOptions(options));
    }
    
    // tm-60
    // Test JniInchiOutput log setter
    @Test
    public void testJniInchiOutputsetLog() throws Exception {
    	JniInchiOutput output = new JniInchiOutput(INCHI_RET.OKAY, new JniInchiOutputStrings("inchi string", "auxinfo string", "message", "log"));
    	output.setLog("new log");
    	  	
    	assertEquals(output.getLog(), "new log");
    }
    
    // tm-61
    // Test JniInchiOutput message setter
    @Test
    public void testJniInchiOutputsetMessage() throws Exception {
    	JniInchiOutput output = new JniInchiOutput(INCHI_RET.OKAY, new JniInchiOutputStrings("inchi string", "auxinfo string", "message", "log"));
    	output.setMessage("new message");
    	  	
    	assertEquals(output.getMessage(), "new message");
    }
    
    // tm-62
    // Test JniInchiOutput return status setter
    @Test
    public void testJniInchiOutputsetReturn() throws Exception {
    	JniInchiOutput output = new JniInchiOutput(INCHI_RET.OKAY, new JniInchiOutputStrings("inchi string", "auxinfo string", "message", "log"));
    	output.setRetStatus(INCHI_RET.FATAL);
    	  	
    	assertEquals(output.getReturnStatus(), INCHI_RET.FATAL);
    }
    
    // tm-63
    // Test JniInchiOutput Inchi setter
    @Test
    public void testJniInchiOutputsetInchi() throws Exception {
    	JniInchiOutput output = new JniInchiOutput(INCHI_RET.OKAY, new JniInchiOutputStrings("inchi string", "auxinfo string", "message", "log"));
    	output.setInchi("new inchi");
    	  	
    	assertEquals(output.getInchi(), "new inchi");
    }
    
    // tm-64
    // Test JniInchiOutput AuxInfo setter
    @Test
    public void testJniInchiOutputsetAux() throws Exception {
    	JniInchiOutput output = new JniInchiOutput(INCHI_RET.OKAY, new JniInchiOutputStrings("inchi string", "auxinfo string", "message", "log"));
    	output.setAuxInfo("new auxinfo");
    	  	
    	assertEquals(output.getAuxInfo(), "new auxinfo");
    }
    
    // tm-65
    // Test JniInchiOutput's overridden toString method
    @Test
    public void testJniInchiOutputToString() throws Exception {
    	JniInchiOutput output = new JniInchiOutput(INCHI_RET.OKAY, new JniInchiOutputStrings("inchi string", "auxinfo string", "message", "log"));
    	  	
    	assertEquals(output.toString(), "InChI_Output: " + INCHI_RET.OKAY + "/inchi string/auxinfo string/message/log");
    }
    
    // tm-66
    // Test JniInchiException's default constructor (no input)
    @Test
    public void testJniInchiExceptionDefaultConstructor() throws Exception {
    	JniInchiException ex = new JniInchiException();
    	
    	assertEquals(ex.getMessage(), null);
    }
    
    // tm-67
    // Test JniInchiException's constructor with a cause
    @Test
    public void testJniInchiExceptionCauseConstructor() throws Exception {
    	Throwable cause = new Throwable("test cause");
    	JniInchiException ex = new JniInchiException(cause);
    	
    	assertEquals(ex.getMessage(), "java.lang.Throwable: test cause");
    }
    
    // tm-68
    // Test LoadNativeLibraryException's default constructor (no input)
    @Test
    public void testLoadNativeLibraryExceptionDefaultConstructor() throws Exception {
    	LoadNativeLibraryException ex = new LoadNativeLibraryException();
    	
    	assertEquals(ex.getMessage(), null);
    }
    
    // tm-69
    // Test LoadNativeLibraryException's constructor with message
    @Test
    public void testLoadNativeLibraryExceptionMessageConstructor() throws Exception {
    	String message = "Exception error message";
    	LoadNativeLibraryException ex = new LoadNativeLibraryException(message);
    	
    	assertEquals(ex.getMessage(), message);
    }
    
    // tm-70
    // Test LoadNativeLibraryException's constructor with a cause
    @Test
    public void testLoadNativeLibraryExceptionCauseConstructor() throws Exception {
    	Throwable cause = new Throwable("test cause");
    	LoadNativeLibraryException ex = new LoadNativeLibraryException(cause);
    	
    	assertEquals(ex.getMessage(), "java.lang.Throwable: test cause");
    }
    
    // tm-71
    // Convert an Inchi into a structure, then convert backwards and make sure the result equals the origin
    @Test
    public void testfromInchitoStructureandBack() throws Exception {
        JniInchiInputInchi inchi = new JniInchiInputInchi("InChI=1S/Na.H2O/h;1H2/q+1;/p-1");
        JniInchiOutputStructure structure = JniInchiWrapper.getStructureFromInchi(inchi);
        
        JniInchiInput convert = new JniInchiInput(structure);
        JniInchiOutput output = JniInchiWrapper.getInchi(convert);
        assertEquals(inchi.getInchi(), output.getInchi());
    }
    
    // tm-72
    // Convert an Inchi into a structure, modify then convert backwards and make sure the resulting Inchi is different
    @Test
    public void testfromInchitoStructureandBackwithChange() throws Exception {
        JniInchiInputInchi inchi = new JniInchiInputInchi("InChI=1S/Na.H2O/h;1H2/q+1;/p-1");
        JniInchiOutputStructure structure = JniInchiWrapper.getStructureFromInchi(inchi);
        // Original compound is sodium hydroxide, add a Nitrogen
        structure.addAtom(new JniInchiAtom(0, 0, 0, "N"));
        
        JniInchiInput convert = new JniInchiInput(structure);
        JniInchiOutput output = JniInchiWrapper.getInchi(convert);
        // Confirm the resulting Inchi string is different from the original
        assertNotSame(inchi.getInchi(), output.getInchi());
    }
    
    /*
     * Test method for 'net.sf.jniinchi.JniInchiBond.JniInchiBond(JniInchiAtom, JniInchiAtom, INCHI_BOND_TYPE, INCHI_BOND_STEREO)'
     */
    @Test
    public void testJniInchiBondJniInchiAtomJniInchiAtomINCHI_BOND_TYPEINCHI_BOND_STEREO() {
        JniInchiBond bond = new JniInchiBond(atO, atT, INCHI_BOND_TYPE.DOUBLE, INCHI_BOND_STEREO.DOUBLE_EITHER);
        Assert.assertEquals(atO, bond.getOriginAtom());
        Assert.assertEquals(atT, bond.getTargetAtom());
        Assert.assertEquals(INCHI_BOND_TYPE.DOUBLE, bond.getBondType());
        Assert.assertEquals(INCHI_BOND_STEREO.DOUBLE_EITHER, bond.getBondStereo());
    }

    /*
     * Test method for 'net.sf.jniinchi.JniInchiBond.JniInchiBond(JniInchiAtom, JniInchiAtom, INCHI_BOND_TYPE)'
     */
    @Test
    public void testJniInchiBondJniInchiAtomJniInchiAtomINCHI_BOND_TYPE() {
        JniInchiBond bond = new JniInchiBond(atO, atT, INCHI_BOND_TYPE.DOUBLE);
        Assert.assertEquals(atO, bond.getOriginAtom());
        Assert.assertEquals(atT, bond.getTargetAtom());
        Assert.assertEquals(INCHI_BOND_TYPE.DOUBLE, bond.getBondType());
        Assert.assertEquals(INCHI_BOND_STEREO.NONE, bond.getBondStereo());
    }

    /*
     * Test method for 'net.sf.jniinchi.JniInchiBond.setStereoDefinition(INCHI_BOND_STEREO)'
     */
    @Test
    public void testSetStereoDefinition() {
        JniInchiBond bond = new JniInchiBond(atO, atT, INCHI_BOND_TYPE.DOUBLE);
        Assert.assertEquals(INCHI_BOND_STEREO.NONE, bond.getBondStereo());
        bond.setStereoDefinition(INCHI_BOND_STEREO.DOUBLE_EITHER);
        Assert.assertEquals(INCHI_BOND_STEREO.DOUBLE_EITHER, bond.getBondStereo());
    }

    /*
     * Test method for 'net.sf.jniinchi.JniInchiBond.getOriginAtom()'
     */
    @Test
    public void testGetOriginAtom() {
        JniInchiBond bond = new JniInchiBond(atO, atT, INCHI_BOND_TYPE.DOUBLE);
        Assert.assertEquals(atO, bond.getOriginAtom());
        bond = new JniInchiBond(atT, atO, INCHI_BOND_TYPE.DOUBLE);
        Assert.assertEquals(atT, bond.getOriginAtom());
    }

    /*
     * Test method for 'net.sf.jniinchi.JniInchiBond.getTargetAtom()'
     */
    @Test
    public void testGetTargetAtom() {
        JniInchiBond bond = new JniInchiBond(atO, atT, INCHI_BOND_TYPE.DOUBLE);
        Assert.assertEquals(atT, bond.getTargetAtom());
        bond = new JniInchiBond(atT, atO, INCHI_BOND_TYPE.DOUBLE);
        Assert.assertEquals(atO, bond.getTargetAtom());
    }

    /*
     * Test method for 'net.sf.jniinchi.JniInchiBond.getBondType()'
     */
    @Test
    public void testGetBondType() {
        JniInchiBond bond = new JniInchiBond(atO, atT, INCHI_BOND_TYPE.DOUBLE);
        Assert.assertEquals(INCHI_BOND_TYPE.DOUBLE, bond.getBondType());
        bond = new JniInchiBond(atO, atT, INCHI_BOND_TYPE.SINGLE);
        Assert.assertEquals(INCHI_BOND_TYPE.SINGLE, bond.getBondType());
    }

    /*
     * Test method for 'net.sf.jniinchi.JniInchiBond.getBondStereo()'
     */
    @Test
    public void testGetBondStereo() {
        JniInchiBond bond = new JniInchiBond(atO, atT, INCHI_BOND_TYPE.DOUBLE, INCHI_BOND_STEREO.DOUBLE_EITHER);
        Assert.assertEquals(INCHI_BOND_STEREO.DOUBLE_EITHER, bond.getBondStereo());
        bond = new JniInchiBond(atO, atT, INCHI_BOND_TYPE.SINGLE, INCHI_BOND_STEREO.SINGLE_1UP);
        Assert.assertEquals(INCHI_BOND_STEREO.SINGLE_1UP, bond.getBondStereo());
    }

}
