package com.clt.srgf;

import java.util.Collection;
import java.util.Map;

/**
 * GenerationOptions can be used to customize the set of strings that are
 * generated by {@link Grammar#generate}.
 *
 * @author Daniel Bobbert
 * @version 1.0
 */
public final class GenerationOptions implements Cloneable {

    public String classFilter = null;
    public boolean groupDictionaries = false;
    public Map<String, Map<String, String>> dynamicVocabulary = null;
    /* repeat branches this many times */
    public int maxRepeats = 1;
    public boolean dynamicVocabularyReplacesOriginalContent = true;
    /* for grammar branches, do a random walk rather than sequentially through all alternatives */
    public boolean randomWalk = false;
    
    /*
     * similarly to maxRepeats in sequential grammar enumeration,
     * add branches to the output until their summed probability reaches this value
     * the semantics is as follows:
     * <= 1 implies sampling without replacement, >1 with replacement (just timo's best guess at what people might want).
     * TODO: would need to be implemented
     */
    public double randomWalkProbSum = -1;

    @Override
    public Object clone() {

        try {
            GenerationOptions options = (GenerationOptions) super.clone();
            return options;
        } catch (Exception exn) {
            return null;
        }
    }

    public Collection<String> getDynamicVocabulary(String wordClass) {

        if (this.dynamicVocabulary == null) {
            return null;
        } else {
            Map<String, String> entry = this.dynamicVocabulary.get(wordClass);
            if (entry == null) {
                return null;
            } else {
                return entry.keySet();
            }
        }
    }

    public String getDynamicVocabularySubstitution(String wordClass, String word) {

        if (this.dynamicVocabulary == null) {
            return word;
        } else {
            Map<String, String> entry = this.dynamicVocabulary.get(wordClass);
            if (entry == null) {
                return word;
            } else {
                return entry.get(word);
            }
        }
    }
}
