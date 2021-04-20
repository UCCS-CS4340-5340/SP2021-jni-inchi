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

/**
 * Encapsulates properites of InChI Stereo Parity.  See <tt>inchi_api.h</tt>.
 * @author Sam Adams
 */
public class JniInchiStereo0D {

    private static final int ATOM0 = 0;
    private static final int ATOM1 = 1;
    private static final int ATOM2 = 2;
    private static final int ATOM3 = 3;
	
	/**
     * Indicates non-existent (central) atom. Value from inchi_api.h.
     */
    private static final int NO_ATOM = -1;

    /**
     * Neighbouring atoms.
     */
    private JniInchiAtom[] neighbors = new JniInchiAtom[4];

    /**
     * Central atom.
     */
    private JniInchiAtom centralAtom;

    /**
     * Stereo parity type.
     */
    private INCHI_STEREOTYPE type;

    /**
     * Parity.
     */
    private INCHI_PARITY parity;

    /**
     * Second parity (for disconnected systems).
     */
    private INCHI_PARITY disconParity = INCHI_PARITY.NONE;

    /**
     * Constructor.  See <tt>inchi_api.h</tt> for details of usage.
     * @param atoms TODO
     * @param type          Stereo parity type
     * @param parity    Parity
     *
     * @see createNewTetrahedralStereo0D()
     * @see createNewDoublebondStereo0D()
     */
    
    public JniInchiStereo0D(NewJniInchiStereo0DAtoms atoms, final INCHI_STEREOTYPE type, final INCHI_PARITY parity) {
        centralAtom = atoms.atC;
        neighbors[ATOM0] = atoms.at0;
        neighbors[ATOM1] = atoms.at1;
        neighbors[ATOM2] = atoms.at2;
        neighbors[ATOM3] = atoms.at3;

        this.type = type;
        this.parity = parity;
    }

    JniInchiStereo0D(final JniInchiAtom atC, final JniInchiAtom at0,
    		final JniInchiAtom at1, final JniInchiAtom at2, final JniInchiAtom at3,
    		final int type, final int parity) {
    	
    	this(new NewJniInchiStereo0DAtoms(atC, at0, at1, at2, at3), INCHI_STEREOTYPE.getValue(type), INCHI_PARITY.getValue(parity));
    }

    
    /**
     * Set second parity (for disconnected systems)
     * @param parity
     */
    public void setDisconnectedParity(final INCHI_PARITY parity) {
        this.disconParity = parity;
    }

    /**
     * Returns central atom of stereo parity.
     * @return
     */
    public JniInchiAtom getCentralAtom() {
        return centralAtom;
    }

    /**
     * Returns neighboring atoms of stereo parity.
     * @return
     */
    public JniInchiAtom[] getNeighbors() {
        return neighbors;
    }
    
    public JniInchiAtom getNeighbor(int i) {
    	return neighbors[i];
    }

    /**
     * Returns parity.
     * @return
     */
    public INCHI_PARITY getParity() {
        return parity;
    }

    /**
     * Returns disconnected parity.
     * @return
     */
    public INCHI_PARITY getDisconnectedParity() {
        return disconParity;
    }

    /**
     * Returns type of stereochemistry.
     * @return
     */
    public INCHI_STEREOTYPE getStereoType() {
        return type;
    }

    /**
     * Generates string representation of information on stereo parity,
     * for debugging purposes.
     */
    public String getDebugString() {
    	String debug = "InChI Stereo0D: ";
    	debug += centralAtom == null ? "-" : centralAtom.getElementType();
    	debug += " [" + neighbors[ATOM0].getElementType() + "," + neighbors[ATOM1].getElementType();
    	debug += "," + neighbors[ATOM2].getElementType() + "," + neighbors[ATOM3].getElementType() + "] ";
    	debug += "Type::" + type + " // ";
    	debug += "Parity:" + parity;
    	
    	return debug;
    }

    /**
     * Outputs information on stereo parity, for debugging purposes.
     */
    public void debug() {
        System.out.println(getDebugString());
    }


    /**
     * <p>Convenience method for generating 0D stereo parities at tetrahedral
     * atom centres.
     *
     * <p><b>Usage notes from <i>inchi_api.h</i>:</b>
     * <pre>
     *  4 neighbors
     *
     *           X                    neighbor[4] : {#W, #X, #Y, #Z}
     *           |                    central_atom: #A
     *        W--A--Y                 type        : INCHI_StereoType_Tetrahedral
     *           |
     *           Z
     *  parity: if (X,Y,Z) are clockwize when seen from W then parity is 'e' otherwise 'o'
     *  Example (see AXYZW above): if W is above the plane XYZ then parity = 'e'
     *
     *  3 neighbors
     *
     *             Y          Y       neighbor[4] : {#A, #X, #Y, #Z}
     *            /          /        central_atom: #A
     *        X--A  (e.g. O=S   )     type        : INCHI_StereoType_Tetrahedral
     *            \          \
     *             Z          Z
     *
     *  parity: if (X,Y,Z) are clockwize when seen from A then parity is 'e',
     *                                                         otherwise 'o'
     *  unknown parity = 'u'
     *  Example (see AXYZ above): if A is above the plane XYZ then parity = 'e'
     *  This approach may be used also in case of an implicit H attached to A.
     *
     *  ==============================================
     *  Note. Correspondence to CML 0D stereo parities
     *  ==============================================
     *  a list of 4 atoms corresponds to CML atomRefs4
     *
     *  tetrahedral atom
     *  ================
     *  CML atomParity > 0 <=> INCHI_PARITY_EVEN
     *  CML atomParity < 0 <=> INCHI_PARITY_ODD
     *
     *                               | 1   1   1   1  |  where xW is x-coordinate of
     *                               | xW  xX  xY  xZ |  atom W, etc. (xyz is a
     *  CML atomParity = determinant | yW  yX  yY  yZ |  'right-handed' Cartesian
     *                               | zW  zX  xY  zZ |  coordinate system)
     * </pre>
     * @param atoms TODO
     * @param parity Parity
     */
    public static JniInchiStereo0D createNewTetrahedralStereo0D(NewJniInchiStereo0DAtoms atoms, INCHI_PARITY parity) {
        JniInchiStereo0D stereo = new JniInchiStereo0D(atoms, INCHI_STEREOTYPE.TETRAHEDRAL, parity);
        return stereo;
    }


    /**
     * <p>Convenience method for generating 0D stereo parities at stereogenic
     * double bonds.
     *
     * <p><b>Usage notes from <i>inchi_api.h</i>:</b>
     * <pre>
     *  =============================================
     *  stereogenic bond >A=B< or cumulene >A=C=C=B<
     *  =============================================
     *
     *                              neighbor[4]  : {#X,#A,#B,#Y} in this order
     *  X                           central_atom : NO_ATOM
     *   \            X      Y      type         : INCHI_StereoType_DoubleBond
     *    A==B         \    /
     *        \         A==B
     *         Y
     *
     *  parity= 'e'    parity= 'o'   unknown parity = 'u'
     *
     *  ==============================================
     *  Note. Correspondence to CML 0D stereo parities
     *  ==============================================
     *
     *  stereogenic double bond and (not yet defined in CML) cumulenes
     *  ==============================================================
     *  CML 'C' (cis)      <=> INCHI_PARITY_ODD
     *  CML 'T' (trans)    <=> INCHI_PARITY_EVEN
     * </pre>
     * @param atoms TODO
     * @param parity Parity
     *
     * @return
     */
    public static JniInchiStereo0D createNewDoublebondStereo0D(NewDoubleBondStereo0DAtoms atoms, final INCHI_PARITY parity) {
    	NewJniInchiStereo0DAtoms complete = new NewJniInchiStereo0DAtoms(null, atoms.at0, atoms.at1, atoms.at2, atoms.at3);
        JniInchiStereo0D stereo = new JniInchiStereo0D(complete, INCHI_STEREOTYPE.DOUBLEBOND, parity);
        return stereo;
    }
    
    
    int getInchiStereoType() {
    	return type.getIndx();
    }
    
    int getInchiParity() {
    	return parity.getIndx();
    }
    
    public static int getNO_ATOM() {
    	return NO_ATOM;
    }
    
}
