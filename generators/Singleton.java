package ke1_rieger_moritz_fx.generators;

/**
 *
 * @author Moritz Rieger
 */
interface Singleton {
    Singleton theInstance = null;
    Generator getInstance();
}
