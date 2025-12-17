<template>
  <div class="add container">
    <h1 class="text-5xl font-semibold tracking-tight text-balance text-gray-900 sm:text-7xl">Add a Fact</h1>
    <p class="mt-8 text-lg font-medium text-pretty text-gray-500 sm:text-xl/8">Add any cool fact from around the world you want to share.</p>

    <form @submit.prevent="submitFact" class="w-full max-w-sm">
      <div class="flex items-center border-b border-blue-500 py-2">
        <input id="fact" v-model="newFact" class="appearance-none bg-transparent border-none w-full text-gray-700 mr-3 py-1 px-2 leading-tight focus:outline-none" type="text" placeholder="Add your fact here" aria-label="Cool Fact">
        <button type="v=buttin" class="flex-shrink-0 bg-blue-500 hover:bg-blue-700 border-blue-500 hover:border-blue-700 text-sm border-4 text-white py-1 px-2 rounded">
          Add Fact
        </button>
      </div>
    </form>

    <p class="mt-8 font-medium text-pretty text-green-500 sm:text-xl/8" v-if="message">{{ message }}</p>
  </div>
</template>

<script>
export default {
  name: "AddFact",
  data() {
    return {
      newFact: "",
      message: ""
    };
  },
  methods: {
    async submitFact() {
      try {
        const response = await fetch("http://localhost:8080/fact", {
          method: "POST",
          headers: {
            "Content-Type": "application/json"
          },
          body: JSON.stringify(this.newFact)
        });

        if (response.ok) {
          this.message = "Fact added successfully!";
          this.newFact = "";
        } else {
          this.message = "Failed to add fact.";
        }
      } catch (error) {
        console.error(error);
        this.message = "Error connecting to backend.";
      }
    }
  }
};
</script>

<style scoped>
.container {
  min-height: 100vh;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  text-align: center;
}
</style>