<template>
  <div class="container">
    <br></br>
    <div class="text-center">
      <h1 class="text-5xl font-semibold tracking-tight text-balance text-gray-900 sm:text-7xl">Cool Facts</h1>
      <div class="mt-10 flex items-center justify-center gap-x-6">
        <button @click="getFact" class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded-full">Show me a fact</button>
      </div>
      <p class="mt-8 text-lg font-medium text-pretty text-gray-500 sm:text-xl/8" v-if="fact">{{ fact }}</p>
    </div>
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
#container {
  display: flex;
  justify-content: center;
  align-items: center;
  text-align: center;
}
</style>