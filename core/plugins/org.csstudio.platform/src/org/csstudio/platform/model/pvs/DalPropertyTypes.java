/* 
 * Copyright (c) 2006 Stiftung Deutsches Elektronen-Synchroton, 
 * Member of the Helmholtz Association, (DESY), HAMBURG, GERMANY.
 *
 * THIS SOFTWARE IS PROVIDED UNDER THIS LICENSE ON AN "../AS IS" BASIS. 
 * WITHOUT WARRANTY OF ANY KIND, EXPRESSED OR IMPLIED, INCLUDING BUT NOT LIMITED 
 * TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR PARTICULAR PURPOSE AND 
 * NON-INFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE 
 * FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, 
 * TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR 
 * THE USE OR OTHER DEALINGS IN THE SOFTWARE. SHOULD THE SOFTWARE PROVE DEFECTIVE 
 * IN ANY RESPECT, THE USER ASSUMES THE COST OF ANY NECESSARY SERVICING, REPAIR OR 
 * CORRECTION. THIS DISCLAIMER OF WARRANTY CONSTITUTES AN ESSENTIAL PART OF THIS LICENSE. 
 * NO USE OF ANY SOFTWARE IS AUTHORIZED HEREUNDER EXCEPT UNDER THIS DISCLAIMER.
 * DESY HAS NO OBLIGATION TO PROVIDE MAINTENANCE, SUPPORT, UPDATES, ENHANCEMENTS, 
 * OR MODIFICATIONS.
 * THE FULL LICENSE SPECIFYING FOR THE SOFTWARE THE REDISTRIBUTION, MODIFICATION, 
 * USAGE AND OTHER RIGHTS AND OBLIGATIONS IS INCLUDED WITH THE DISTRIBUTION OF THIS 
 * PROJECT IN THE FILE LICENSE.HTML. IF THE LICENSE IS NOT INCLUDED YOU MAY FIND A COPY 
 * AT HTTP://WWW.DESY.DE/LEGAL/LICENSE.HTM
 */
package org.csstudio.platform.model.pvs;

import java.util.HashMap;
import java.util.Map;

import org.csstudio.platform.simpledal.ValueType;
import org.epics.css.dal.DoubleProperty;
import org.epics.css.dal.DoubleSeqProperty;
import org.epics.css.dal.DynamicValueProperty;
import org.epics.css.dal.EnumProperty;
import org.epics.css.dal.LongProperty;
import org.epics.css.dal.LongSeqProperty;
import org.epics.css.dal.ObjectSeqProperty;
import org.epics.css.dal.StringProperty;
import org.epics.css.dal.StringSeqProperty;

/**
 * 
 * @author Sven Wende
 * @version $Revision$
 * @deprecated Use {@link ValueType} instead!
 */
public enum DalPropertyTypes {
	/**
	 * An array of double values.
	 */
	ENUM("enum", "Enumeration", EnumProperty.class), //$NON-NLS-1$
	
	/**
	 * An array of double values.
	 */
	DOUBLE_SEQUENCE("doubleSeq", "Sequence of Doubles", DoubleSeqProperty.class), //$NON-NLS-1$

	/**
	 * An array of string values.
	 */
	STRING_SEQUENCE("stringSeq", "Sequence of Strings", StringSeqProperty.class), //$NON-NLS-1$

	/**
	 * An array of long values.
	 */
	LONG_SEQUENCE("longSeq", "Sequence of Longs", LongSeqProperty.class), //$NON-NLS-1$

	/**
	 * An array of object values.
	 */
	OBJECT_SEQUENCE("objectSeq", "Sequence of Objects", ObjectSeqProperty.class), //$NON-NLS-1$

	/**
	 * An option.
	 */
	LONG("long", "Long", LongProperty.class), //$NON-NLS-1$

	/**
	 * A double value.
	 */
	DOUBLE("double", "Double", DoubleProperty.class), //$NON-NLS-1$

	/**
	 * A string.
	 */
	STRING("string", "String", StringProperty.class); //$NON-NLS-1$

	/**
	 * The ID of the property type. Will be used as portable representation of
	 * the created instance.
	 */
	private String _id;

	private String _description;
	
	/**
	 * A hint for the necessary DAL property type.
	 */
	@SuppressWarnings("unchecked")
	private Class<? extends DynamicValueProperty> _dalType;

	/**
	 * Constructor.
	 * 
	 * @param id
	 *            The ID. Will be used as portable representation of the created
	 *            instance.
	 * @param javaType
	 *            the Java type, which is expected for property values
	 * @param dalType
	 *            a hint for the necessary DAL property type
	 */
	@SuppressWarnings("unchecked")
	private DalPropertyTypes(final String id, String description,
			final Class<? extends DynamicValueProperty> dalType) {
		assert id != null;
		assert description !=null;
		assert dalType != null;
		_id = id;
		_description = description;
		_dalType = dalType;
	}

	/**
	 * @return An ID that allows for persisting and recreating instances of this
	 *         class.
	 */
	public String toPortableString() {
		return _id;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return _description;
	}

	/**
	 * {@inheritDoc}
	 */
	public Class<? extends DynamicValueProperty> getDalType() {
		return _dalType;
	}

	/**
	 * A map that contains all instances of this class.
	 */
	private static Map<String, DalPropertyTypes> _mapping;

	static {
		_mapping = new HashMap<String, DalPropertyTypes>();

		for (DalPropertyTypes type : DalPropertyTypes.values()) {
			_mapping.put(type.toPortableString(), type);
		}
	}

	/**
	 * Creates an instance of this class from a string representation.
	 * 
	 * @param portableString
	 *            Required.
	 * @return The instance that is represented by the string or null
	 */
	public static DalPropertyTypes createFromPortable(
			final String portableString) {
		assert portableString != null;
		DalPropertyTypes result = null;
		if (_mapping.containsKey(portableString)) {
			result = _mapping.get(portableString);
		}

		return result;
	}

}
