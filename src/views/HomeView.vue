<template>
  <div id="app">
    <h1>Cool Facts</h1>
    <button @click="getFact">Show me a fact</button>
    <p v-if="fact">{{ fact }}</p>
  </div>
</template>

<script>
export default {
  data() {
    return {
      fact: null
    };
  },
  methods: {
    async getFact() {
      const facts = [
        "It is said that the term 'bug' in computing came about in 1947 when a moth was found to be the cause of a malfunction in the Harvard Mark II computer, however in reality the term bug was already used by Thomas Edison and other engineers in the 1870s to describe electrical faults as if they were pesky bugs.",
        "Quantum entanglement is when two particles can be linked in such a way that observing the properties of one instantaneously affects the other, regardless of the distance separating them, even if they were across the universe. Einstein called this 'spooky action at a distance'.",
        "From what we know of time dilation and relativity, time does not pass at the same speed for everyone. According to Einstein's theory of relativity, time moves slower for objects in strong gravitational fields or moving at high speeds. As a result GPS satellites need constant correction to function accurately."
      ];
      this.fact = facts[Math.floor(Math.random() * facts.length)];
    }
  }
};
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  text-align: center;
  margin-top: 50px;
}
button {
  padding: 10px 20px;
  margin: 20px;
  cursor: pointer;
}
</style>
