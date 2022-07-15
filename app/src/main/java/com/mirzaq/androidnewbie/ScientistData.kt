package com.mirzaq.androidnewbie

object ScientistData {
    private val scientistName = arrayOf(
        "Albert Einstein",
        "Isaac Newton",
        "Galileo Galilei",
        "Johannes Kepler",
        "Max Planck",
        "Stephen Hawking",
        "Marie Curie",
        "Charles Darwin",
        "Nikola Tesla",
        "J. Robert Oppenheimer",
        "Thomas Alva Edison",
        "James Watt",
    )

    private val scientistImage = arrayOf(
        R.drawable.albert_einstein,
        R.drawable.isaac_newton,
        R.drawable.galileo_galilei,
        R.drawable.johannes_kepler,
        R.drawable.max_planck,
        R.drawable.stephen_hawking,
        R.drawable.marie_curie,
        R.drawable.charles_darwin,
        R.drawable.nikola_tesla,
        R.drawable.j_robert_oppenheimer,
        R.drawable.thomas_alva_edison,
        R.drawable.james_watt,
    )

    private val scientistDetail = arrayOf(
        "Albert Einstein was a German-born theoretical physicist who developed the theory of relativity, one of the two pillars of modern physics. He is often called the Father of Physics",
        "Isaac Newton is a British mathematician, physicist, and inventor. He is best known for his work in optics, and for his contributions to the scientific community",
        "Galileo was a founding member of the Italian mathematical society. He was a founding member of the Italian mathematical society, and was a founding member of the Italian mathematical society",
        "Johannes Kepler was a German astronomer who developed the telescope, the first telescope ever to be built. He was also the first to use the telescope to measure the distance between the stars",
        "Max Planck is a German theoretical physicist who developed the quantum theory of light. He is also known for his contributions to the physics of black holes",
        "Stephen Hawking is a British theoretical physicist and cosmologist who discovered the existence of the universe and created the theory of the universe",
        "Marie Curie was a Polish and French physicist and chemist who conducted pioneering work on radioactivity and nuclear physics. She is the recipient of the Nobel Prize in Physics in1939",
        "Charles Darwin was a British scientist who is best known for his work in natural history. He is also known for his contributions to the field of evolution",
        "Nikola Tesla is a Serbian-born American inventor and electrical engineer. He received the Tesla Award in 2003 and is best known for his contributions to the design of the modern alternating current (AC) electricity supply system",
        "J. Robert Oppenheimer was a German-American biochemist, physical chemist, and geologist who is credited with the development of the modern atomic bomb. He was also the founder of the Institute for Atomic Research",
        "Thomas Edison was an American inventor and businessman. He invented the alternating current (AC) electricity supply system and the phonograph",
        "James Watt was an American scientist who developed the first practical electric power source. He is best known for his invention of the phonograph",
    )

    private val scientistBorn = arrayOf(
        "1879",
        "1776",
        "1564",
        "1688",
        "1815",
        "1910",
        "1898",
        "1876",
        "1898",
        "1898",
        "1898",
        "1898",
    )

    val listData: ArrayList<Scientist>
        get() {
            val list = arrayListOf<Scientist>()
            for (position in scientistName.indices) {
                val scientist = Scientist()
                scientist.name = scientistName[position]
                scientist.image = scientistImage[position]
                scientist.detail = scientistDetail[position]
                scientist.born = scientistBorn[position]
                list.add(scientist)
            }
            return list
        }
}